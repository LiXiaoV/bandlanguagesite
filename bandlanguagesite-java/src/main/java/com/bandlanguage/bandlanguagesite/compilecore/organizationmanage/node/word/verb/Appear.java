package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

import java.util.List;

public class Appear extends Verb {
    public String text;

    public Appear(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        Object subject = Environment.environment.get("Subject");
        if (object instanceof List) {
            System.out.println("出现在 ** 和 ** 中");
        } else {
            System.out.println("出现在 *** 中");
        }
        return res;
    }
}
