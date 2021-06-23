package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.Adverbial;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;

//predicate_adverbial_object_stmt  谓状宾句 统计 ***对象 中 元素 的 数量
public class SimpleStmt5 extends SimpleStmt {
    public Predicate predicate;
    public Adverbial adverbial;
    public B_Object BObject;

    /**
     * 将整个句子的相关部分，放入语境中，之后执行单个节点
     * @param methodName
     * @return
     */
    @Override
    public boolean run(String methodName) {//查找 通讯录集合 中 成员 的 姓名
         //执行顺序 状语--宾语--谓语
        boolean res = adverbial.run(null) &&
                BObject.run(null) &&
                predicate.run(null);
        return res;
    }
}
