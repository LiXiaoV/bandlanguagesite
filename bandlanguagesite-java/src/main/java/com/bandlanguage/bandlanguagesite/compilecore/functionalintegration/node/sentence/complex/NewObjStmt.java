package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb.NewObj;

import java.util.List;

public class NewObjStmt extends ComplexStmt {
    public List<Compare> conditionList ; //可能附带的条件
    public NewObj verb;
    public String name;

    @Override
    public boolean run(String methodName) {
        return false;
    }
}
