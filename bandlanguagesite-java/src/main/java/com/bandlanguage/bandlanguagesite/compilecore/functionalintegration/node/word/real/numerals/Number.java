package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.numerals;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;

//'数字'
public class Number extends Numerals {

    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        try {
            Integer num = Integer.valueOf(this.text);
            if (num != null){
                environment.add(this.text,num, BLObjType.RESULT_INTEGER, EnvironmentType.STACK);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
