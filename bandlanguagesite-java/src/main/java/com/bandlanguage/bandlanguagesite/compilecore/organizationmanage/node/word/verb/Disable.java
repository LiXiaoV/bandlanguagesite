package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Disable extends Verb {
    public String text;

    public Disable(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        Object attribute = Environment.environment.get("Attribute");
        if (attribute == null) {
            System.out.println("禁用工具" + object.toString());
        } else {
            switch (object.toString()) {
                case "工具":
                    System.out.println("禁用工具ID为" + attribute.toString());
                    break;
                default:
                    res = false;
                    System.out.println("语义不正确");
                    break;
            }
        }
        return res;
    }
}
