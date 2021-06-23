package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun;


import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

//'输入部件'
public class InputPart extends Noun {
    @Override
    public boolean run(String methodName) {
        return inputPart();
    }

    private boolean inputPart(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.find("宾语");
        if(obj == null){
            return false;
        }else {
            obj = (BLObj)obj.value;
            if(obj.type != BLObjType.TOOLID){
                return false;
            }
        }
        String toolID = obj.value.toString();

        JSONObject outPutPart = getInPutPart(toolID);
        environment.add(this.text,outPutPart,BLObjType.RESULT_JSONOBJECT, EnvironmentType.STACK);
        return true;
    }

    //调用帮区接口来得到相关信息
    private JSONObject getInPutPart(String toolID){
        return new JSONObject();
    }
}
