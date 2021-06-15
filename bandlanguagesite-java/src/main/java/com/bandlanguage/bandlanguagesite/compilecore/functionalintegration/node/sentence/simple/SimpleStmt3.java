package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.subject.Subject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;

//subject_predicate_object_stmt  主谓宾句
public class SimpleStmt3 extends SimpleStmt {
    public Subject subject;
    public Predicate predicate;
    public B_Object BObject;

    /**
     * 将整个句子的相关部分，放入语境中，之后执行单个节点
     * @param methodName
     * @return
     */
    @Override
    public boolean run(String methodName) {
        //执行顺序 主语--宾语--谓语
        boolean res = subject.run(null);
        if(res){
            res = BObject.run(null);
            if(res){
                predicate.run(null);
            }
        }
        return res;
    }
}
