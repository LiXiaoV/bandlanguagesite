package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object;


import com.alibaba.fastjson.JSONArray;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

import java.util.LinkedList;
import java.util.List;

//
public class Object1 extends B_Object {
    public List<ObjectSingle> list = new LinkedList<>(); // 各具体词
    public List<ObjectSplit> splits = new LinkedList<>(); //分割字符

    @Override
    public boolean run(String methodName) {
        //暂时不考虑分隔符的事情
        Environment environment = EnvironmentConst.environment.get();

        if(list == null || list.size() <= 0){
            return false;
        }
        //如果是单个，则直接将宾语的结果放入语境
        if(list.size()==1){
            boolean r = list.get(0).run(null);
            if(!r){
                return false;
            }
            return true;
        }else {
            //如果是多个，先组合之后，再放入
            JSONArray jsonArray = new JSONArray();
            for (ObjectSingle node : list){
                boolean r = node.run(null);
                if(!r){
                    return false;
                }
                BLObj blObj = environment.findWithDelete("宾语");
                blObj = (BLObj) blObj.value;
                blObj.key = node.text;
                jsonArray.add(blObj);
            }
            BLObj obj = new BLObj(this.text,jsonArray, BLObjType.RESULT_JSONARRAY);
            environment.add("宾语",obj, BLObjType.BLObj, EnvironmentType.STACK);
        }
        return true;
    }

}
