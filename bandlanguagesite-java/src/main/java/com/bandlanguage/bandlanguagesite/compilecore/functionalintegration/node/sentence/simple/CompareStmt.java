package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex.Compare;

//疑问句
public class CompareStmt extends SimpleStmt {
    public Compare compare;


    @Override
    public boolean run(String methodName) {
        return compare.run(null);
    }

}
