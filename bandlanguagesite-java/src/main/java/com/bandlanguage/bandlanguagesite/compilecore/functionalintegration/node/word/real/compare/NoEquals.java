package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.compare;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

//'不等于'
public class NoEquals extends CompareWord {
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
        //全部转换为字符串进行比较
        if(!left.value.toString().equals(right.value.toString())){
            environment.add("结果",true, BLObjType.RESULT_BOOLEAN, EnvironmentType.STACK);
        }else {
            environment.add("结果",false, BLObjType.RESULT_BOOLEAN,EnvironmentType.STACK);
        }
        return true;
    }
}
