package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective.Adjective;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Identifier;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Str;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Noun;

public class Attribute extends Element {

    public Adjective adjective;
    public Str str;
    public Identifier identifier;
    public Noun noun;

    @Override
    public boolean run(String methodName) {
        boolean res = false;
        String s = "";
        if (adjective != null) {
            res = adjective.run(methodName);
            s = "Adjective";
        }
        if (str != null) {
            res = str.run(methodName);
            s = "Str";
        }
        if (identifier != null) {
            res = identifier.run(methodName);
            s = "Identifier";
        }
        if (noun != null) {
            res = noun.run(methodName);
            s = "Noun";
        }
        if (res) {
            Object o = Environment.environment.get(s);
            Environment.environment.put("Attribute", o);
            Environment.environment.remove(s);
        }
        return res;
    }
}
