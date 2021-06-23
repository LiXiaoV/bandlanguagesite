package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//分组句
public class GroupStmt extends ComplexStmt {
    public String para; //属性名称
    public String objName; //对象名称

    /**
     *
     * @param methodName
     * @return
     */
    @Override
    public boolean run(String methodName) {
        return group();
    }

    /**
     * 将objName所对应的数据集合，按照para进行分组(相同的放到一起，但整体还是一个集合)
     * @return 如果objName不是集合，或者属性对应的值不能比较，则返回false,否则返回true
     */
    public boolean group(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj data = environment.find(objName);
        if(null == data || data.type!= BLObjType.RESULT_JSONARRAY){
            return false;
        }
        List<JSONObject> list = JSONArray.parseArray(data.value.toString(), JSONObject.class);
        HashMap<String,List<JSONObject>> all = new HashMap<>();
        for(JSONObject a : list){
            String v = a.getString(para);
            if(all.containsKey(v)){
                all.get(v).add(a);
            }else {
                List<JSONObject> l = new LinkedList<>();
                l.add(a);
                all.put(v,l);
            }
        }
        List<JSONObject> newList = new LinkedList<>();
        for (String k : all.keySet()){
            newList.addAll(all.get(k));
        }
        data.value = JSONArray.parseArray(newList.toString());
        return true;
    }
}
