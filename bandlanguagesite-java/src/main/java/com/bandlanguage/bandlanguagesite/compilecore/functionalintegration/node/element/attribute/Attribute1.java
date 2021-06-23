package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.adjective.Adjective;

//情况一： 形容词 的
// 损坏的 最大的 最小的
//adjective De
public class Attribute1 extends Attribute {
    public Adjective adjective;

    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = new BLObj(adjective.text,adjective, BLObjType.Node);
        environment.add("定语", obj, BLObjType.BLObj, EnvironmentType.STACK);
        return true;
    }
}
