package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

public class Rename extends Verb {

    @Override
    public boolean run(String methodName) {
        return rename();
    }

    public boolean rename(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj object = environment.findWithDelete("宾语");
        BLObj target = environment.findWithDelete("目标");
        object = (BLObj)object.value;
        object.key = target.value.toString();
        return true;
    }
}
