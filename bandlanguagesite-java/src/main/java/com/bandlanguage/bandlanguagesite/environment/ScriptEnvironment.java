package com.bandlanguage.bandlanguagesite.environment;

import com.alibaba.fastjson.JSON;
import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.result.ResultCode;

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

    public void setMap(Map<String,Object> map){
        this.map=map;
    }

    @Override
    public Map<String, Object> getAll() {
        return map;
    }

    @Override
    public void add(String key, Object value) {
        map.put(key,value);
    }

    @Override
    public void addAll(Map<String, Object> map) {
        this.map.putAll(map);
    }

    @Override
    public Environment remove(String key) {
        this.map.remove(key);
        return this;
    }

    @Override
    public void updateEnvironmentInRedis() {
        throw new GlobalException(ResultCode.VERIFICATION_CODE_FAIL);
    }

    @Override
    public Boolean isKeyInEnvironment(String key) {
        return this.map.containsKey(key);
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }
}
