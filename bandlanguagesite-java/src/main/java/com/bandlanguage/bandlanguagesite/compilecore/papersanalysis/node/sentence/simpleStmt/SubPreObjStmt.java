package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.sentence.simpleStmt;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element.Obj;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element.Subject;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.script.SimpleStmt;

public class SubPreObjStmt extends SimpleStmt {

    public Subject subject;
    public Predicate predicate;
    public Obj object;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        if (subject != null){
            res = subject.run(methodName);
        }
        if (res){
            res = object.run(methodName);
        }
        if (res){
            res = predicate.run(methodName);
        }
        return res;
    }
}
