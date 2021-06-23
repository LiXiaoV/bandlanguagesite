package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.script;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.Node;

import java.util.ArrayList;
import java.util.List;

public class Script implements Node {

    public List<Stmt> stmtList = new ArrayList<>();

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        for (Stmt stmt: stmtList) {
            if(res){
                res = stmt.run("");
            }
        }
        return res;
    }
}
