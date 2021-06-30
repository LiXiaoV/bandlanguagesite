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
        if(!generatingOrganizationId.contains(id)){
            synchronized (OrganizationEnvironmentFactory.class){
                if(!generatingOrganizationId.contains(id)&&isNotInRedis(id)){
                    generatingOrganizationId.add(id);
                    environment=new OrganizationEnvironment(id);
                    saveInRedis(environment,id);
                    generatingOrganizationId.remove(id);
                }
            }
        }
        return environment;
    }

    @Override
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

    private void removeFromRedis(Long id){
        cache.del(EnvironmentKey.instance.getPrefix()+"organization"+id);
    }
}
