package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Identifier;

public class Subject extends Element {

    public Long loginUser;
    public Identifier identifier;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        if (identifier != null) {
            res = identifier.run(methodName);
            if (res) {
                Environment.environment.put("Subject", Environment.environment.get("Identifier"));
            }
        }
        return res;
    }
}
