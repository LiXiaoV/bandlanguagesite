package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Attribute;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Subject;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.SimpleStmt;

public class SubPreAttrObjStmt extends SimpleStmt {

    public Subject subject;
    public Predicate predicate;
    public Attribute attribute;
    public Obj obj;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        if (subject != null){
            res = subject.run(methodName);
        }
        if (res){
            res = obj.run(methodName);
        }
        if (res){
            res = attribute.run(methodName);
        }
        if (res){
            res = predicate.run(methodName);
        }
        return res;
    }
}
