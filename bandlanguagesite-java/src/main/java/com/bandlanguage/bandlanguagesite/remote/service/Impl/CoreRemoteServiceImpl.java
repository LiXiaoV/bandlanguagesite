package com.bandlanguage.bandlanguagesite.remote.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.remote.service.CoreRemoteService;
import com.bandlanguage.bandlanguagesite.util.WtbCoreUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 **/
public class CoreRemoteServiceImpl implements CoreRemoteService {

    @Override
    public JSONObject getBandIdByBandObjId(List<Long> bandObjIds) throws Exception {

        Map<String,Object> params=new HashMap<String, Object>();

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("%5B");
        for (Long bandObjId:bandObjIds
             ) {
            stringBuffer.append(bandObjId.toString());
        }
        stringBuffer.append("%5D");
        params.put("objIDs",stringBuffer.toString());

        String accessToken = WtbCoreUtil.getInstance().getAccessToken();

        String api="/core/v4/user/me/objs";
        JSONObject jsonObject = WtbCoreUtil.getInstance().doGet(api, accessToken, params);

        System.out.println(jsonObject);

        return jsonObject;
    }

    @Override
    public JSONObject getDepartmentByOrganizationId(Long organizationId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/organization/");
        api.append(organizationId+"/department");

        return WtbCoreUtil.getInstance().doGet(api.toString(), WtbCoreUtil.getInstance().getAccessToken(),params);
  }

    @Override
    public JSONObject getPositionByOrganizationId(Long organizationId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/organization/");
        api.append(organizationId+"/position");

        return WtbCoreUtil.getInstance().doGet(api.toString(), WtbCoreUtil.getInstance().getAccessToken(),params);
    }
}
