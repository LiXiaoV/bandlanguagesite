package com.bandlanguage.bandlanguagesite.environment;

/**
 *
 **/
public class ScriptEnvironmentFactory implements  EnvironmentFactory{


    @Override
    public Environment createEnvironment(Long id) throws Exception {
        return new ScriptEnvironment(id);
    }

    @Override
    public Environment updateEnvironment(Long id) throws Exception {
        return null;
    }
}
