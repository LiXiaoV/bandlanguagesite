package com.bandlanguage.bandlanguagesite.environment;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.util.SpringContextUtils;

import java.util.Map;

/**
 *
 **/
public class DepartmentEnvironmentFactory implements EnvironmentFactory {

    private volatile DepartmentEnvironmentFactory instance;

    private IGlobalCache cache;

    private DepartmentEnvironmentFactory() {
        cache= SpringContextUtils.getBean(IGlobalCache.class);
    }

    public DepartmentEnvironmentFactory getInstance(){
        if(instance==null){
            synchronized (DepartmentEnvironmentFactory.class){
                if(instance==null){
                    instance=new DepartmentEnvironmentFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Environment createEnvironment(Long id) throws Exception {



        return null;
    }

    @Override
    public Environment createEnvironment(Long id, Map<String, Object> map) throws Exception {

        Environment environment=new DepartmentEnvironment(map, id);

        return environment;
    }
}
