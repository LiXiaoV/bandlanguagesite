package com.bandlanguage.bandlanguagesite.environment;

/**
 *
 **/
public class ScriptEnvironmentFactory implements  EnvironmentFactory{


    private ScriptEnvironmentFactory(){}

    private static volatile ScriptEnvironmentFactory instance;

    public static ScriptEnvironmentFactory getInstance(){
        if(instance==null){
            synchronized (ScriptEnvironmentFactory.class){
                if(instance==null){
                    instance=new ScriptEnvironmentFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Environment createEnvironment(Long id) throws Exception {
        return new ScriptEnvironment(id);
    }

}
