package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.placeadverbial;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.PlaceAdverbial;

//地点状语情况一 At String (In)?
public class PlaceAdverbial1 extends PlaceAdverbial {
    public String string;//剧本中的词

    @Override
    public boolean run(String methodName) {
        //目前，地点状语仅支持指定帮区和机构
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj ;
        if (environment.organization.name.equals(string)){ //如果是机构名称
            obj = environment.find(string, EnvironmentType.ORGANIZATION);
        }else if(environment.band.name.equals(string)){ //如果是帮区名称
            obj = environment.find(string,EnvironmentType.BAND);
        }else {
            return false;
        }
        environment.add("状语",obj, BLObjType.BLObj, EnvironmentType.STACK);
        return true;
    }
}
