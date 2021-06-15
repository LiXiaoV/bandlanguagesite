package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.timeadverbial;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.TimeAdverbial;

//时间状语情况一 At time
public class TimeAdverbial1 extends TimeAdverbial {
    public Node time;

    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        boolean res = time.run(null);
        //执行错误
        if(!res){
            return false;
        }
        BLObj obj = environment.findWithDelete("时间");
        if(null == obj){
            return false;
        }else {
            environment.add("状语",obj, BLObjType.BLObj, EnvironmentType.STACK);
            return true;
        }
    }
}
