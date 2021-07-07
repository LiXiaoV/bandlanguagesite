package com.bandlanguage.bandlanguagesite.environment;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.util.SpringContextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 **/
public class BandEnvironmentFactory implements EnvironmentFactory{

    private static volatile List<Long> generatingBand;

    private static IGlobalCache cache;

    private BandEnvironmentFactory(){
        cache= SpringContextUtils.getBean(IGlobalCache.class);
    }

    private static volatile BandEnvironmentFactory instance;

    public static BandEnvironmentFactory getInstance(){
        if(instance==null){
            synchronized (BandEnvironmentFactory.class){
                if(instance==null){
                    instance=new BandEnvironmentFactory();
                    generatingBand=new ArrayList<Long>();
                }
            }
        }
        return instance;
    }

    @Override
    public Environment createEnvironment(Long id) throws Exception{
        Environment environment=null;
        if(isNotInRedis(id)){
            environment=new BandEnvironment(id);
            saveInRedis(environment,id);
        }else{
            Map<String, Object> map = getFromRedis(id);
            environment=new BandEnvironment(id,map);
        }
        return environment;
    }

    @Override
    public Environment createEnvironment(Long id, Map<String, Object> map) throws Exception {
        Environment environment=new BandEnvironment(id,map);
        return environment;
    }

    public Environment updateEnvironment(Long id) throws Exception {
        Environment environment=null;
        if(!generatingBand.contains(id)){
            synchronized (BandEnvironmentFactory.class){
                if(!generatingBand.contains(id)){
                    if(!isNotInRedis(id)){
                        removeFromRedis(id);
                    }
                    generatingBand.add(id);
                    environment=new BandEnvironment(id);
                    saveInRedis(environment,id);
                    generatingBand.remove(id);
                }
            }
        }
        return null;
    }

    private void saveInRedis(Environment environment, Long id){
        cache.set(EnvironmentKey.instance.getPrefix() +"band"+id,environment);
    }

    private Map<String,Object> getFromRedis(Long bandId){
        return (Map<String, Object>) ((Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix() +"band"+bandId)).get("all");
    }

    private Boolean isNotInRedis(Long id){
        return cache.get(EnvironmentKey.instance.getPrefix()+"band"+id)==null;
    }

    private void removeFromRedis(Long id){
        cache.del(EnvironmentKey.instance.getPrefix()+"band"+id);
    }
}
