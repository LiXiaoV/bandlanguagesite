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
public class OrganizationEnvironmentFactory implements EnvironmentFactory {

    private static volatile List<Long> generatingOrganizationId;

    private static IGlobalCache cache;

    private OrganizationEnvironmentFactory(){
        cache= SpringContextUtils.getBean(IGlobalCache.class);
    }

    private static volatile OrganizationEnvironmentFactory instance;

    public static OrganizationEnvironmentFactory getInstance(){
        if(instance==null){
            synchronized (OrganizationEnvironmentFactory.class){
                if(instance==null){
                    instance=new OrganizationEnvironmentFactory();
                    generatingOrganizationId=new ArrayList<Long>();
                }
            }
        }
        return instance;
    }

    @Override
    public Environment createEnvironment(Long id) throws Exception{
        Environment environment=null;
        if(isNotInRedis(id)){
            environment=new OrganizationEnvironment(id);
            saveInRedis(environment,id);
        }else{
            Map<String, Object> map = getFromRedis(id);
            environment=new OrganizationEnvironment(id,map);
        }
        return environment;
    }

    @Override
    public Environment createEnvironment(Long id, Map<String, Object> map) throws Exception {
        Environment environment=new OrganizationEnvironment(id,map);
        return environment;
    }

    public Environment updateEnvironment(Long id) throws Exception {

        Environment environment=null;

        if(!generatingOrganizationId.contains(id)){
            synchronized (OrganizationEnvironmentFactory.class){
                if(!generatingOrganizationId.contains(id)){
                    if(!isNotInRedis(id)){
                        removeFromRedis(id);
                    }
                    generatingOrganizationId.add(id);
                    environment=new OrganizationEnvironment(id);
                    saveInRedis(environment,id);
                    generatingOrganizationId.remove(id);
                }
            }
        }

        return environment;
    }

    private void saveInRedis(Environment environment, Long id){
        cache.set(EnvironmentKey.instance.getPrefix() +"organization"+id,environment);
    }

    private Boolean isNotInRedis(Long id){
        return cache.get(EnvironmentKey.instance.getPrefix()+"organization"+id)==null;
    }

    private Map<String,Object> getFromRedis(Long id){
        return (Map<String, Object>) ((Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"organization"+id)).get("all");
    }

    private void removeFromRedis(Long id){
        cache.del(EnvironmentKey.instance.getPrefix()+"organization"+id);
    }
}
