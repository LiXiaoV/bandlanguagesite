package com.bandlanguage.bandlanguagesite.environment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class BandEnvironmentFactory implements EnvironmentFactory{

    private static volatile List<Long> generatingBand;

    private BandEnvironmentFactory(){}

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
                if(!generatingBand.contains(id)){
                    generatingBand.add(id);
                    environment=new BandEnvironment(id);
                    generatingBand.remove(id);
                }
            }
        }
        return environment;
    }
}
