package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.complexStmt;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.ComplexStmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.SimpleStmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt.JudgeStmt;

import java.util.List;

public class IfStmt extends ComplexStmt {

    public JudgeStmt judgeStmt;
    public List<SimpleStmt> simpleStmts;

    @Override
    public boolean run(String methodName) {
        return super.run(methodName);
    }
}
