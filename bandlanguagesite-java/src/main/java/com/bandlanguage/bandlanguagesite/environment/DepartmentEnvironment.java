package com.bandlanguage.bandlanguagesite.environment;

import java.util.Map;

/**
 *
 **/
public class DepartmentEnvironment extends Environment {

    private Map<String,Object> map;

    private Long departmentId;

    public DepartmentEnvironment(Map<String, Object> map, Long departmentId) {
        this.map = map;
        this.departmentId = departmentId;
    }

    public DepartmentEnvironment(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public void add(String key, Object value) {

    }

    @Override
    public void addAll(Map<String, Object> map) {

    }

    @Override
    public Environment remove(String key) {
        return null;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public Map<String, Object> getAll() {
        return null;
    }

    @Override
    public void updateEnvironmentInRedis() {

    }

    @Override
    public Boolean isKeyInEnvironment(String key) {
        return null;
    }
}
