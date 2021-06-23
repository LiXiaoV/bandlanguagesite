package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;

//predicate_object_stmt  谓宾句
public class SimpleStmt4 extends SimpleStmt {
    public Predicate predicate;
    public B_Object BObject;

    /**
     * 将整个句子的相关部分，放入语境中，之后执行单个节点
     * @param methodName
     * @return
     */
    @Override
    public boolean run(String methodName) {
        boolean res = BObject.run(null);
        if(res){
            res = predicate.run(null);
        }
        return res;
    }
}
