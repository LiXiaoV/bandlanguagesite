package com.bandlanguage.bandlanguagesite.environment;

import java.io.Serializable;
import java.util.Map;

/**
 *
 **/
public abstract class Environment implements Serializable {

    public abstract void add(String key, Object value);

    public abstract void addAll(Map<String,Object> map);

    public abstract Environment remove(String key);

    public abstract Object get(String key);

    public abstract Map<String,Object> getAll();

    public abstract void updateEnvironmentInRedis();

    public abstract Boolean isKeyInEnvironment(String key);

}
