package com.bandlanguage.bandlanguagesite.environment;

import com.bandlanguage.bandlanguagesite.remote.service.CoreRemoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
public class BandEnvironment extends Environment {

    @Autowired
    private CoreRemoteService coreRemoteService;

    private Map<String,Object> map;

    private Long bandId;

    public BandEnvironment(Long bandId) {
        this.bandId = bandId;
        map=new HashMap<String, Object>();

    }

    @Override
    public void set(String key, Object value) {
        map.put(key,value);
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public Map<String, Object> getEnvironment() {
        return map;
    }
}
