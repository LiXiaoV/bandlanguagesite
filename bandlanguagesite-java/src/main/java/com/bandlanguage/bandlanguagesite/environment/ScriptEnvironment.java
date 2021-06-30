package com.bandlanguage.bandlanguagesite.environment;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
public class ScriptEnvironment extends Environment{

    private Map<String,Object> map;

    private Long scriptId;

    public ScriptEnvironment(Long scriptId) {
        this.scriptId = scriptId;

        map=new HashMap<String, Object>();
    }

    public void setMap(String map) {
        this.map = JSON.parseObject(map);
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
