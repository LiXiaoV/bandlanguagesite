package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.ObjectSingle;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb.Verb;

public class BaStmt extends ComplexStmt {
    public B_Object object;
    public Verb verb;
    public ObjectSingle objectSingle;
    public String condition;

    @Override
    public boolean run(String methodName) {
        return merge();
    }

    public boolean merge(){
        Environment environment = EnvironmentConst.environment.get();
        boolean res = object.run(null);
        if(!res){
            return false;
        }
        environment.add("目标",objectSingle.text, BLObjType.RESULT_STRING, EnvironmentType.STACK);
        if(condition != null){
            environment.add("条件",condition, BLObjType.RESULT_STRING, EnvironmentType.STACK);
        }
        return verb.run(null);
    }
}
