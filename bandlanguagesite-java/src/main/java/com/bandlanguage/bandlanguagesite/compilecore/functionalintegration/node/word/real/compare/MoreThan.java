package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.compare;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

//'大于'
public class MoreThan extends CompareWord {

    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj left = environment.findWithDelete("左值");
        BLObj right = environment.findWithDelete("右值");
        if(left == null || right == null){
            return false;
        }
        left = (BLObj)left.value;
        right = (BLObj)right.value;
        Integer l,r;
        try {
            l = Integer.valueOf(left.value.toString());
            r = Integer.valueOf(right.value.toString());
        }catch (Exception e){
            //不能转换为数字
            return false;
        }

        if(l>r){
            environment.add("结果",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);
        }else {
            environment.add("结果",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);
        }
        return true;
    }
}
