package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun;


import com.alibaba.fastjson.JSONArray;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

//'数量'
public class Amount extends Noun {
    @Override
    public boolean run(String methodName) {
        return getAmount();
    }

    private boolean getAmount(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.find("宾语");
        obj = (BLObj)obj.value;
        //没有或者类型不对
        if(obj == null || obj.type != BLObjType.RESULT_JSONARRAY){
            return false;
        }

        try {
            JSONArray res = JSONArray.parseArray(obj.value.toString());
            environment.add(this.text,res.size(),BLObjType.RESULT_INTEGER, EnvironmentType.STACK);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
