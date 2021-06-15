package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb.Verb;

//情况一 verb
public class Predicate1 extends Predicate {
    public Verb verb; //谓语

    @Override
    public boolean run(String methodName) {
        return verb.run(null);
    }
}
