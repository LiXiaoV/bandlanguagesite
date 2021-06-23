package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Identifier;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Num;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Str;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.noun.Noun;

public class Obj extends Element {

    public Num num;
    public Str str;
    public Identifier identifier;
    public Noun noun;

    @Override
    public boolean run(String methodName) {
        boolean res = false;
        String s = "";
        if (num != null) {
            res = num.run(methodName);
            s = "Num";
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
            Environment.environment.put("Object", o);//o environmentobject
            Environment.environment.remove(s);
        }
        return res;
    }
}
