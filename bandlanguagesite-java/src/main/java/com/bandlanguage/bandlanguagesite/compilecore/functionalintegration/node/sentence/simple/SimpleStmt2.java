package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute.Attribute;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;

//predicate_attribute_object_stmt  谓定宾句
public class SimpleStmt2 extends SimpleStmt {
    public Predicate predicate;
    public Attribute attribute;
    public B_Object BObject;

    /**
     * 将整个句子的相关部分，放入语境中，之后执行单个节点
     * @param methodName
     * @return
     */
    @Override
    public boolean run(String methodName) {
        //执行顺序 定语-宾语-谓语
        boolean res = attribute.run(null);
        if(res){
            res = BObject.run(null);
            if(res){
                res = predicate.run(null);
            }
        }
        return res;
    }
}
