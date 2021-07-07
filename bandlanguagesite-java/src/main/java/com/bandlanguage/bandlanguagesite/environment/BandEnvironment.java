package com.bandlanguage.bandlanguagesite.environment;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.remote.service.CoreRemoteService;
import com.bandlanguage.bandlanguagesite.remote.service.Impl.CoreRemoteServiceImpl;
import com.bandlanguage.bandlanguagesite.util.SpringContextUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 **/
public class BandEnvironment extends Environment {

    private CoreRemoteService coreRemoteService;

    private Map<String,Object> map;

    private Long bandId;

    private String updateTime;

    private IGlobalCache cache;

    private static final long serialVersionUID = -5809782578272943999L;

    public BandEnvironment(Long bandId) throws Exception {
        this.bandId = bandId;
        cache= SpringContextUtils.getBean(IGlobalCache.class);

        map=new HashMap<String, Object>();
        coreRemoteService=new CoreRemoteServiceImpl();

        map.put("bandRoles",getRoles());
        map.put("bandUsers",getUsers());
        map.put("bandChatrooms",getChatrooms());
        map.put("bandDocuments",getDocuments());
        map.put("bandInfo",getBandInfo());
        map.put("bandTools",getTools());

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateTime=simpleDateFormat.format(new Date());
    }

    public BandEnvironment(Long bandId,Map<String,Object> map) throws Exception{
        this.bandId = bandId;
        cache= SpringContextUtils.getBean(IGlobalCache.class);
        coreRemoteService=new CoreRemoteServiceImpl();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateTime=simpleDateFormat.format(new Date());

        this.map=map;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.updateTime = simpleDateFormat.format(updateTime);
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
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String,Object> environment=new HashMap<String, Object>();
        environment.putAll(map);
        environment.put("updateTime",updateTime);
        return environment;
    }

    @Override
    public void updateEnvironmentInRedis() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            updateTime=simpleDateFormat.format(new Date());
        this.saveInRedis(600);
    }

    @Override
    public Boolean isKeyInEnvironment(String key) {
        return this.map.containsKey(key);
    }

    private void saveInRedis(long expiredTime){
        cache.set(EnvironmentKey.instance.getPrefix() +"band"+bandId,this,expiredTime);
    }

    private Map<String,Object> getBandInfo() throws Exception{
        JSONObject bandInfo = coreRemoteService.getBandInfo(bandId);
        JSONArray rows = bandInfo.getJSONArray("rows");

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("bandName",rows.getJSONObject(0).get("name"));
        map.put("bandId",bandId);
        map.put("bandObjId",rows.getJSONObject(0).get("realObjID"));

        return map;
    }

    private List<Map<String,Object>> getRoles() throws Exception{
        JSONObject rolesInBand = coreRemoteService.getRolesInBand(this.bandId);
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        JSONArray rows = rolesInBand.getJSONArray("rows");
        for (int i = 0; i < rows.size(); i++) {
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("roleName",rows.getJSONObject(i).get("roleName"));
            temp.put("roleId",rows.getJSONObject(i).get("roleID"));
            list.add(temp);
        }
        return list;
    }

    private List<Map<String,Object>> getUsers() throws Exception{
        JSONObject membersInBand = coreRemoteService.getUsersInBand(bandId);
        JSONArray members = membersInBand.getJSONArray("rows");
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for (int i = 0; i < members.size(); i++) {
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("userName",members.getJSONObject(i).get("userName"));
            temp.put("userAccount",members.getJSONObject(i).get("userAccount"));
            temp.put("userId",members.getJSONObject(i).get("userID"));
            list.add(temp);
        }
        return list;
    }

    private List<Map<String,Object>> getChatrooms() throws Exception{
        JSONObject chatroomsInBand = coreRemoteService.getChatroomsInBand(bandId);
        JSONArray rows = chatroomsInBand.getJSONArray("rows");
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for (int i = 0; i < rows.size(); i++) {
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("chatroomName",rows.getJSONObject(i).get("chatroomName"));
            temp.put("chatroomDescription",rows.getJSONObject(i).get("description"));
            temp.put("chatroomUserNumber",rows.getJSONObject(i).get("roomUserNumber"));
            temp.put("chatroomId",rows.getJSONObject(i).get("chatroomID"));
            list.add(temp);
        }
        return list;
    }

    private List<Map<String,Object>> getDocuments() throws Exception{
        JSONObject documentsInBand = coreRemoteService.getDocumentsInBand(bandId);
        JSONArray rows = documentsInBand.getJSONArray("rows");
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for (int i = 0; i < rows.size(); i++) {
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("documentName",rows.getJSONObject(i).get("name"));
            temp.put("documentId",rows.getJSONObject(i).get("documentID"));
            temp.put("documentExtension",rows.getJSONObject(i).get("extension"));
            temp.put("documentDescription",rows.getJSONObject(i).get("description"));
            list.add(temp);
        }

        return list;
    }

    private List<Map<String,Object>> getTools() throws Exception{
        JSONObject toolsInBand = coreRemoteService.getToolsInBand(bandId);
        JSONArray rows = toolsInBand.getJSONArray("rows");
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();

        for (int i = 0; i < rows.size(); i++) {
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("toolId",rows.getJSONObject(i).get("toolID"));
            temp.put("toolName",rows.getJSONObject(i).get("name"));
            list.add(temp);
        }

        return list;
    }
}
