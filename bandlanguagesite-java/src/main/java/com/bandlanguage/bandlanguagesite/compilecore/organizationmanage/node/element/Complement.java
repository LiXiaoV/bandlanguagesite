package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.TimeComp;

public class Complement extends Element {

    public TimeComp timeComp;

    @Override
    public boolean run(String methodName) {
        if (timeComp != null) {
            return timeComp.run(methodName);
        } else {
            return true;
        }
    }
}
