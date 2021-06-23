package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Verb;

public class Predicate extends Element {

    public Verb verb;

    @Override
    public boolean run(String methodName) {
        boolean res = false;
        res = verb.run(methodName);
        return res;
    }
}
