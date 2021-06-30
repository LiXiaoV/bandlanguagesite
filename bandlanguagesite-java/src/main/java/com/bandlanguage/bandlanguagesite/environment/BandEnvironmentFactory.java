package com.bandlanguage.bandlanguagesite.environment;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.util.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
        if(!generatingBand.contains(id)){
            synchronized (BandEnvironmentFactory.class){
                if(!generatingBand.contains(id)&&isNotInRedis(id)){
                    generatingBand.add(id);
                    environment=new BandEnvironment(id);
                    saveInRedis(environment,id);
                    generatingBand.remove(id);
                }
            }
        }
        return environment;
    }

    @Override
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

    private Boolean isNotInRedis(Long id){
        return cache.get(EnvironmentKey.instance.getPrefix()+"organization"+id)==null;
    }

    private void removeFromRedis(Long id){
        cache.del(EnvironmentKey.instance.getPrefix()+"organization"+id);
    }
}
