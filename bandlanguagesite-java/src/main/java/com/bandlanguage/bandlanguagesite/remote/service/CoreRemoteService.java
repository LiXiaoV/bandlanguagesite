package com.bandlanguage.bandlanguagesite.remote.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface CoreRemoteService {

    //通过帮区Obj获取用户所在帮区信息
    Map<String,Object> getBandByBandObjId(List<Long> bandObjIds) throws Exception;

    //
    JSONObject getRolesInBand(Long bandId) throws Exception;

    JSONObject getUsersInBand(Long bandId) throws Exception;

    JSONObject getChatroomsInBand(Long bandId) throws Exception;

    JSONObject getDocumentsInBand(Long bandId) throws Exception;

    JSONObject getToolsInBand(Long bandId) throws Exception;

    JSONObject getBandInfo(Long bandId) throws Exception;

    JSONObject getOrganizationInfo(Long organizationId) throws Exception;

    //通过机构id获取机构内的部门信息
    JSONObject getDepartmentByOrganizationId(Long organizationId) throws Exception;

    //通过机构id获取机构内的岗位信息
    JSONObject getPositionByOrganizationId(Long organizationId) throws Exception;

    JSONObject getMembersByOrganizationId(Long organizationId) throws Exception;
}
