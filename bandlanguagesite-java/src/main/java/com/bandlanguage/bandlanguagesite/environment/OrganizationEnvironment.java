package com.bandlanguage.bandlanguagesite.environment;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.remote.service.CoreRemoteService;
import com.bandlanguage.bandlanguagesite.remote.service.Impl.CoreRemoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
public class OrganizationEnvironment extends Environment {

    CoreRemoteService coreRemoteService;

    private Map<String,Object> map;

    private Long organizationId;

    public OrganizationEnvironment(Long organizationId) throws Exception {

        this.organizationId = organizationId;

        coreRemoteService=new CoreRemoteServiceImpl();

        map=new HashMap<String, Object>();

        //调用核心api
        JSONObject departments = coreRemoteService.getDepartmentByOrganizationId(organizationId);
        System.out.println(departments);
        map.put("department",departments);
        JSONObject positions = coreRemoteService.getPositionByOrganizationId(organizationId);
        System.out.println(positions);
        map.put("position",positions);
    }

    @Override
    public Map<String, Object> getEnvironment() {
        return map;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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
