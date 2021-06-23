package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.commonadverbial;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.CommonAdverbial;

//通用状语情况一 String In
public class CommonAdverbial1 extends CommonAdverbial {
    public String string; //剧本中的词

    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.find(string);
        if(null == obj){
            return false;
        }else {
            environment.add("状语",obj, BLObjType.BLObj, EnvironmentType.STACK);
            return true;
        }
    }
}
