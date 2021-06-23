package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Appoint extends Verb {
    public String text;

    public Appoint(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        Object attribute = Environment.environment.get("Attribute");
        Object adverbial = Environment.environment.get("Adverbial");
        if (object instanceof String) {
            switch (object.toString()) {
                case "岗位":
                    System.out.println("为 ** 任命 **");
                    Environment.envStack.push("addUsersToPosition");
                    break;
                default:
                    res = false;
                    System.out.println("语义有误");
                    break;
            }
        }
        return super.run(methodName);
    }
}
