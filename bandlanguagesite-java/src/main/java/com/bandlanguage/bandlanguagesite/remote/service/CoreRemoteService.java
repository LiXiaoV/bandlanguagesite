package com.bandlanguage.bandlanguagesite.remote.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface CoreRemoteService {

    //通过帮区Obj获取用户所在帮区信息
    JSONObject getBandIdByBandObjId(List<Long> bandObjIds) throws Exception;

    //通过机构id获取机构内的部门信息
    JSONObject getDepartmentByOrganizationId(Long organizationId) throws Exception;

    //通过机构id获取机构内的岗位信息
    JSONObject getPositionByOrganizationId(Long organizationId) throws Exception;
}
