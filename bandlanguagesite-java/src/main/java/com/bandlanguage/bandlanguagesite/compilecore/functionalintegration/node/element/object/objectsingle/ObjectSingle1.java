package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.objectsingle;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.ObjectSingle;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.Str;

//情况一  Str
public class ObjectSingle1 extends ObjectSingle {
    public Str str;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Environment environment = EnvironmentConst.environment.get();
        if(str == null || str.run(null) == false){
            return false;
        }
        BLObj obj = environment.findWithDelete(str.text);
        if(obj == null){
            return false;
        }

        environment.add("宾语",obj, BLObjType.BLObj, EnvironmentType.STACK);
        return res;
    }
}
