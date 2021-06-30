package com.bandlanguage.bandlanguagesite.remote.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.remote.service.CoreRemoteService;
import com.bandlanguage.bandlanguagesite.util.WtbCoreUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 **/
@Service
public class CoreRemoteServiceImpl implements CoreRemoteService {

    @Override
    public Map<String, Object> getBandByBandObjId(List<Long> bandObjIds) throws Exception {

        Map<String,Object> params=new HashMap<String, Object>();

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("[");
        for (Long bandObjId:bandObjIds
             ) {
            stringBuffer.append(bandObjId.toString());
        }
        stringBuffer.append("]");
        params.put("objIDs",stringBuffer.toString());

        String accessToken = WtbCoreUtil.getInstance().getAccessToken();

        String api="/core/v4/user/me/objs";
        JSONObject jsonObject = WtbCoreUtil.getInstance().doGet(api, accessToken, params);

        JSONArray rows = jsonObject.getJSONArray("rows");

        return rows.getJSONObject(0);
    }

    @Override
    public JSONObject getRolesInBand(Long bandId) throws Exception {
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/band/");
        api.append(bandId);
        api.append("/role");
        String accessToken = WtbCoreUtil.getInstance().getAccessToken();
        JSONObject jsonObject = WtbCoreUtil.getInstance().doGet(api.toString(), accessToken, new HashMap<String, Object>());

        return jsonObject;
    }

    @Override
    public JSONObject getUsersInBand(Long bandId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/band/");
        api.append(bandId);
        api.append("/user");
        String accessToken = WtbCoreUtil.getInstance().getAccessToken();
        return WtbCoreUtil.getInstance().doGet(api.toString(),accessToken,params);
    }

    @Override
    public JSONObject getChatroomsInBand(Long bandId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/band/");
        api.append(bandId);
        api.append("/chatroom");
        String accessToken = WtbCoreUtil.getInstance().getAccessToken();
        return WtbCoreUtil.getInstance().doGet(api.toString(),accessToken,params);
    }

    @Override
    public JSONObject getDocumentsInBand(Long bandId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/band/");
        api.append(bandId);
        api.append("/document");

        return WtbCoreUtil.getInstance().doGet(api.toString(),WtbCoreUtil.getInstance().getAccessToken(),params);
    }

    @Override
    public JSONObject getToolsInBand(Long bandId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/band/");
        api.append(bandId);
        api.append("/tool");

        return WtbCoreUtil.getInstance().doGet(api.toString(),WtbCoreUtil.getInstance().getAccessToken(),params);
    }

    @Override
    public JSONObject getBandInfo(Long bandId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/band/");
        api.append(bandId);

        return WtbCoreUtil.getInstance().doGet(api.toString(),WtbCoreUtil.getInstance().getAccessToken(),params);
    }

    @Override
    public JSONObject getOrganizationInfo(Long organizationId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        StringBuffer api=new StringBuffer();
        api.append("/core/v4/organization/");
        api.append(organizationId);

        return WtbCoreUtil.getInstance().doGet(api.toString(),WtbCoreUtil.getInstance().getAccessToken(),params);
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

    @Override
    public JSONObject getMembersByOrganizationId(Long organizationId) throws Exception {
        Map<String,Object> params=new HashMap<String, Object>();
        Map<String,Object> query=new HashMap<String, Object>();

        StringBuffer api=new StringBuffer();
        api.append("/core/v4/organization/");
        api.append(organizationId+"/user");

        query.put("userType","ORDINARY_USER");

        params.put("query",query);

        return WtbCoreUtil.getInstance().doGet(api.toString(),WtbCoreUtil.getInstance().getAccessToken(),params);
    }
}
