package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.Adverbial;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute.Attribute;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;

//predicate_adverbial_attribute_object_stmt  谓状定宾句 执行 测试帮区中 可用的 请假工具
public class SimpleStmt1 extends SimpleStmt {
    public Predicate predicate;
    public Adverbial adverbial;
    public Attribute attribute;
    public B_Object BObject;

    /**
     * 将整个句子的相关部分，放入语境中，之后执行单个节点
     * @param methodName
     * @return
     */
    @Override
    public boolean run(String methodName) {//查找 通讯录集合 中 年龄大于10 的 成员 的 姓名
         //执行顺序 状语--定语--宾语--谓语run
        boolean res = adverbial.run(null);
        if(res){
            //定语执行压入栈中，在第一个宾语执行后执行定语
            if(attribute.run(null)) {
                res = BObject.run(null);
                if(res){
                    res = predicate.run(null);
                }
            }
        }
        return res;
    }
}
