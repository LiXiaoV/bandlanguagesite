package com.bandlanguage.bandlanguagesite.environment;

import java.util.Map;

/**
 *
 **/
public abstract class Environment {

    public abstract void set(String key,Object value);

    public abstract Object get(String key);

    public abstract Map<String,Object> getEnvironment();

}
