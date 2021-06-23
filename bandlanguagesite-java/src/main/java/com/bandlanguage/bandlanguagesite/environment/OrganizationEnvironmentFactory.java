package com.bandlanguage.bandlanguagesite.environment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class OrganizationEnvironmentFactory implements EnvironmentFactory {

    private static volatile List<Long> generatingOrganizationId;

    private OrganizationEnvironmentFactory(){}

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
                if(!generatingOrganizationId.contains(id)){
                    generatingOrganizationId.add(id);
                    environment=new OrganizationEnvironment(id);
                    generatingOrganizationId.remove(id);
                }
            }
        }
        return environment;
    }
}
