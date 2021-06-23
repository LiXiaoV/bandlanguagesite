package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;

//'元素'
public class Element extends Noun {
    @Override
    public boolean run(String methodName) {
        return getElement();
    }

    private boolean getElement(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj zhuang = environment.find("状语", EnvironmentType.STACK);
        //没有或者类型不对
        if(zhuang == null || zhuang.type != BLObjType.BLObj){
            return false;
        }else {
            zhuang = (BLObj)zhuang.value;
            if(zhuang.type != BLObjType.RESULT_JSONARRAY){
                return false;
            }
        }
        JSONArray val = JSONArray.parseArray(zhuang.value.toString());

        BLObj obj = environment.find("定语",EnvironmentType.STACK);

        //如果有定语，一般是要将宾语进行过滤的
        if(obj != null){
            obj = (BLObj)obj.value;
            Node ding = (Node)obj.value;
            JSONArray newVal = new JSONArray();
            for (int i=0;i<val.size();i++){
                JSONObject a = val.getJSONObject(i);
                BLObj jl = new BLObj(this.text,a,BLObjType.RESULT_JSONOBJECT);
                environment.add("宾语",jl,BLObjType.BLObj,EnvironmentType.STACK);
                boolean runRes = ding.run("compare");
                if(!runRes){
                    return false;
                }
                BLObj res = environment.findWithDelete("结果");
                if(res == null || res.type != BLObjType.RESULT_BOOLEAN){
                    return false;
                }
                if((Boolean)res.value){
                    newVal.add(a);
                }
                environment.delete("宾语",EnvironmentType.STACK);
            }
            val = newVal;
        }
        environment.add(this.text,val,BLObjType.RESULT_JSONARRAY, EnvironmentType.STACK);
        return true;
    }

}
