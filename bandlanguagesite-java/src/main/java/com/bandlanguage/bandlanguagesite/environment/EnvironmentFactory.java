package com.bandlanguage.bandlanguagesite.environment;

import java.util.Map;

/**
 *
 **/
public interface EnvironmentFactory {

    public Environment createEnvironment(Long id) throws Exception;

    Environment createEnvironment(Long id, Map<String,Object> map) throws Exception;

}
