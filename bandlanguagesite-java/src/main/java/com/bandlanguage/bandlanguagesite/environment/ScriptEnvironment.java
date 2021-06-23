package com.bandlanguage.bandlanguagesite.environment;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
public class ScriptEnvironment extends Environment{

    private Map<String,Object> map;

    private Long sessionId;

    public ScriptEnvironment(Long sessionId) {
        this.sessionId = sessionId;

        map=new HashMap<String, Object>();
    }

    @Override
    public Map<String, Object> getEnvironment() {
        return map;
    }

    @Override
    public void set(String key, Object value) {
        map.put(key,value);
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }
}
