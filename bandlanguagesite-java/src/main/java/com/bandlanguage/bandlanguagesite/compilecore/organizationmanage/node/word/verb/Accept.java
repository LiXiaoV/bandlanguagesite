package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Accept extends Verb {
    public String text;

    public Accept(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        Object adverbial = Environment.environment.get("Adverbial");
        System.out.println("调用拉人接口");
        return res;
    }
}
