package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.*;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.SimpleStmt;

public class SubAdvPreComAttrObjStmt extends SimpleStmt {

    public Subject subject;
    public Adverbial adverbial;
    public Predicate predicate;
    public Complement complement;
    public Attribute attribute;
    public Obj obj;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        if (adverbial != null){
            res = adverbial.run(methodName);
        }
        if (subject != null){
            res = subject.run(methodName);
        }
        if (res){
            res = obj.run(methodName);
        }
        if (attribute != null){
            res = attribute.run(methodName);
        }
        if (res) {
            res = complement.run(methodName);
        }
        if (res){
            res = predicate.run(methodName);
        }
        return res;
    }
}
