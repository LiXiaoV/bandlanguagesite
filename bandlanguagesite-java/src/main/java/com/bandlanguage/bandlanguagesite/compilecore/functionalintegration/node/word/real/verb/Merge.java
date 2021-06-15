package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Merge extends Verb {
    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj object = environment.findWithDelete("宾语");
        //没有宾语
        if(object == null){
            return false;
        }
        object = (BLObj) object.value;
        //不是多个对象
        if(object.type != BLObjType.RESULT_JSONARRAY){
            return false;
        }
        JSONArray objects = (JSONArray)object.value;
        BLObj target = environment.findWithDelete("目标");
        String newName = target.value.toString();
        BLObj condition = environment.findWithDelete("条件");
        String cond = null;
        if(condition != null){
            cond = condition.value.toString();
        }
        return merge(objects,newName,cond);
    }

    private boolean merge(JSONArray objects,String name,String condition){
        Environment environment = EnvironmentConst.environment.get();
        BLObj one = (BLObj) objects.get(0);
        //暂时不考虑类型不一致，数据错误等问题
        if(one.type == BLObjType.RESULT_JSONARRAY){
            //集合之间的合并
            if(condition == null){
                //直接增加
                JSONArray res = new JSONArray();
                for (int i=0;i<objects.size();i++){
                    BLObj obji = (BLObj)objects.get(i);
                    res.addAll((JSONArray)obji.value);
                }
                environment.add(name,res,BLObjType.RESULT_JSONARRAY, EnvironmentType.MEMORY);
                return true;
            }else {
                //连接
                List<HashSet<String>> listSet = new LinkedList<>();
                for (int i=0;i<objects.size();i++){
                    HashSet<String> a = new HashSet<>();
                    BLObj obji = (BLObj)objects.get(i);
                    JSONArray va = (JSONArray)obji.value;
                    for(int j=0;j<va.size();j++){
                        a.add(((JSONObject)va.get(j)).get(condition).toString());
                    }
                    listSet.add(a);
                }
                for(int i=1;i<listSet.size();i++){
                    HashSet<String> first = listSet.get(0);
                    HashSet<String> second = listSet.get(i);
                    first.retainAll(second);
                }
                HashSet<String> all = listSet.get(0); //所有集合都包含的属性值
                HashMap<String,JSONObject> res = new HashMap<>();
                BLObj obji = (BLObj)objects.get(0);
                JSONArray va = (JSONArray)obji.value;
                for(int j=0;j<va.size();j++){
                    JSONObject oneObj = (JSONObject)va.get(j);
                    if(all.contains(oneObj.getString(condition))){
                        res.put(oneObj.getString(condition),oneObj);
                    }
                }
                for (int i=1;i<objects.size();i++){
                    BLObj x = (BLObj)objects.get(i);
                    JSONArray y = (JSONArray)x.value;
                    for(int j=0;j<y.size();j++){
                        JSONObject yj = (JSONObject)y.get(j);
                        if(all.contains(yj.getString(condition))){
                            JSONObject aa = res.get(yj.getString(condition));
                            aa.putAll(yj);
                            res.put(yj.getString(condition),aa);
                        }
                    }
                }
                JSONArray jsonArray = new JSONArray();
                for(String a : res.keySet()){
                    jsonArray.add(res.get(a));
                }
                environment.add(name,jsonArray,BLObjType.RESULT_JSONARRAY, EnvironmentType.MEMORY);
                return true;
            }
        }else if(one.type == BLObjType.RESULT_JSONOBJECT){
            //单一对象之间的合并
            JSONObject res = new JSONObject();
            for (int i=0;i<objects.size();i++){
                BLObj obji = (BLObj)objects.get(i);
                res.putAll((JSONObject)obji.value);
            }
            environment.add(name,res,BLObjType.RESULT_JSONOBJECT, EnvironmentType.MEMORY);
            return true;
        }else {
            return false;
        }
    }
}
