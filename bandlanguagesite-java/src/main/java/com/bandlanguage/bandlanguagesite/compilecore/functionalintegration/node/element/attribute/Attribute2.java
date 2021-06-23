package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex.Compare;

//情况二: (条件判断句子) 的 元素 的 (属性名称 的)
// 年龄大于10 的 元素 的 个数     性别等于男的 元素 的  年龄 的 最大值
//compare_stmt De
public class Attribute2 extends Attribute {
    public Compare compare;

    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = new BLObj(compare.text,compare, BLObjType.Node);
        environment.add("定语", obj, BLObjType.BLObj, EnvironmentType.STACK);
        return true;
    }

}
