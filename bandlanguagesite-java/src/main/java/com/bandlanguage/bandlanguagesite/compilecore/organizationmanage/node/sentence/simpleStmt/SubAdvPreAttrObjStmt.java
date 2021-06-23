package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.*;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.SimpleStmt;

public class SubAdvPreAttrObjStmt extends SimpleStmt {

    public Subject subject;
    public Adverbial adverbial;
    public Predicate predicate;
    public Attribute attribute;
    public Obj obj;

    @Override
    public boolean run(String methodName) {
        //ignore methodName
        boolean res = false;
        res = adverbial.run(methodName);
        if (res){
            if (subject != null){
                res = subject.run(methodName);
            }
            res = obj.run(methodName);

            if (attribute != null){
                res = attribute.run(methodName);
            }
            if (res){
                res = predicate.run(methodName);
            }
        }
        return res;
    }
}
