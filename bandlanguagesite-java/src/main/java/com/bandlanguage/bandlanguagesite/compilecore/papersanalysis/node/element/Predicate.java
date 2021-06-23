package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.verb.Verb;

public class Predicate extends Element {

    public Verb verb;

    @Override
    public boolean run(String methodName) {
        boolean res;
        res = verb.run(methodName);
        return res;
    }
}
