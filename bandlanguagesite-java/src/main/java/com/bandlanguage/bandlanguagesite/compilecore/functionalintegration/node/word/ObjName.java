package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

import java.util.ArrayList;
import java.util.List;

public class ObjName extends Word {
    @Override
    public boolean run(String methodName) {
        return findObj();
    }

    /**
     * 当前用的查询对象的顺序
     * 先看有没有宾语，如果有，看是否有这个属性，有则把这个属性插入栈中
     * 如果没有这个属性或者宾语，则将这个看成语境中的某个对象，进行查找
     * @return
     */
    public boolean findObj(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj blObj;

        //尝试从对象中获取属性----优先级是  宾语->状语
        BLObj bing = environment.find("宾语", EnvironmentType.STACK);
        BLObj zhuang = environment.find("状语",EnvironmentType.STACK);
        if(bing != null){
            blObj = (BLObj)bing.value;
        }else if (zhuang != null){
            blObj = (BLObj)zhuang.value;
        }else {
            blObj = null;
        }

        if(blObj != null ){
            if(blObj.type == BLObjType.RESULT_JSONOBJECT){
                //如果是单个对象，则取单个值
                JSONObject json = JSONObject.parseObject(blObj.value.toString());
                if(json.containsKey(this.text)){
                    //取值，并根据类型来判断后放入栈
                    Object val = json.get(this.text);
                    BLObjType type = BLObjType.get(val);
                    if(type != null){
                        //是合适的类型
                        environment.add(this.text,val,type,EnvironmentType.STACK);
                        return true;
                    }
                }
            }
            if(blObj.type == BLObjType.RESULT_JSONARRAY){
                //如果是对象数组，则求得List
                JSONArray json = JSONArray.parseArray(blObj.value.toString());
                List<Object> res = new ArrayList<>();
                for(int i=0;i<json.size();i++){
                    JSONObject a = json.getJSONObject(i);
                    if(a.containsKey(this.text)){
                        res.add(a.get(this.text));
                    }
                }
                if(res.size()>0){
                    environment.add(this.text,res,BLObjType.RESULT_LIST,EnvironmentType.STACK);
                    return true;
                }
            }
        }

        //下面，则是将字符串当成key来查找对象
        blObj = environment.find(this.text);
        if(blObj == null){
            //如果没找到，则在这里，假设是后面要获取的对象，在这里把字符串本身放进去
            environment.add(this.text,this.text,BLObjType.RESULT_STRING, EnvironmentType.STACK);
        }else {
            environment.add(this.text,blObj.value,blObj.type, EnvironmentType.STACK);
        }
        return true;
    }

}
