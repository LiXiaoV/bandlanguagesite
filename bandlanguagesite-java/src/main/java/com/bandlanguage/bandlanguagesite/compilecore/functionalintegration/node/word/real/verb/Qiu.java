package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

//'求'
public class Qiu extends Verb {
    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.findWithDelete("宾语");
        if(obj == null){
            return false;
        }else {
            obj = (BLObj)obj.value;
        }
        boolean res = environment.showForUser.add(obj.value.toString());
        return res;
    }
}
