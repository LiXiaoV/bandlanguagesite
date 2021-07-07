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
public class OrganizationEnvironment extends Environment {

    CoreRemoteService coreRemoteService;

    private IGlobalCache cache;

    private Map<String,Object> map;

    private Long organizationId;

    private String updateTime;

    private static final long serialVersionUID = -5809782578272943998L;

    public OrganizationEnvironment(Long organizationId) throws Exception {

        this.organizationId = organizationId;

        cache= SpringContextUtils.getBean(IGlobalCache.class);

        coreRemoteService=new CoreRemoteServiceImpl();

        map =new HashMap<String, Object>();

        //调用核心api
        map.put("department",getDepartments());

        map.put("position", getPositions());

        map.put("users", getUsers());

        map.put("organizationInfo",getOrganizationInfo());

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateTime=simpleDateFormat.format(new Date());

    }

    public OrganizationEnvironment(Long organizationId,Map<String,Object> map) throws Exception{
        this.organizationId=organizationId;
        cache= SpringContextUtils.getBean(IGlobalCache.class);
        coreRemoteService=new CoreRemoteServiceImpl();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateTime=simpleDateFormat.format(new Date());

        this.map =map;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String,Object> environment=new HashMap<String, Object>();
        environment.putAll(this.map);
        environment.put("updateTime",updateTime);
        return environment;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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
    public void updateEnvironmentInRedis(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateTime=simpleDateFormat.format(new Date());
        this.saveInRedis(600);
    }

    @Override
    public Boolean isKeyInEnvironment(String key) {
        return this.map.containsKey(key);
    }

    private void saveInRedis(long expiredTime){
        cache.set(EnvironmentKey.instance.getPrefix() +"organization"+organizationId,this,expiredTime);
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.updateTime = dateFormat.format(updateTime);
    }

    private Map<String,Object> getOrganizationInfo() throws Exception{
        JSONObject organizationInfo = coreRemoteService.getOrganizationInfo(organizationId);
        JSONArray rows = organizationInfo.getJSONArray("rows");
        Map<String,Object> map=new HashMap<String, Object>();

        map.put("organizationId",organizationId);
        map.put("organizationName",rows.getJSONObject(0).get("organizationName"));
        map.put("address",rows.getJSONObject(0).get("address"));
        map.put("introduction",rows.getJSONObject(0).get("introduction"));
        map.put("mainBandID",rows.getJSONObject(0).get("mainBandID"));

        return map;
    }

    private List<Map<String,Object>> getDepartments() throws Exception{
        JSONObject departments = coreRemoteService.getDepartmentByOrganizationId(organizationId);
        JSONArray departmentsArray = departments.getJSONArray("rows");
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for(int i=0;i<departmentsArray.size();i++){
            JSONObject jsonObject=departmentsArray.getJSONObject(i);
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("departmentName",jsonObject.get("departmentName"));
            temp.put("departmentId",jsonObject.get("departmentID"));
            list.add(temp);
        }
        return list;
    }

    private List<Map<String,Object>> getPositions() throws Exception{
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        JSONObject positions = coreRemoteService.getPositionByOrganizationId(organizationId);
        JSONArray positionArray=positions.getJSONArray("rows");
        for(int i=0;i<positionArray.size();i++){
            JSONObject jsonObject=positionArray.getJSONObject(i);
            Map<String,Object> temp=new HashMap<String, Object>();
            temp.put("positionName",jsonObject.get("name"));
            temp.put("positionId",jsonObject.get("positionID"));
            list.add(temp);
        }

        return list;
    }

    private List<Map<String,Object>> getUsers() throws Exception{
        JSONObject jsonObject = coreRemoteService.getMembersByOrganizationId(organizationId);
        JSONArray members = jsonObject.getJSONArray("rows");
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
}
