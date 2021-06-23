package com.bandlanguage.bandlanguagesite.environment;

/**
 *
 **/
public interface EnvironmentFactory {

    public Environment createEnvironment(Long id) throws Exception;

}
