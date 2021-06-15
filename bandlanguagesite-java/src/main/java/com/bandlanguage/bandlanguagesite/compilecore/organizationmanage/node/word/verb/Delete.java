package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Delete extends Verb {
    public String text;

    public Delete(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        if (object instanceof String) {
            switch (object.toString()) {
                case "岗位":
                    System.out.println("移除岗位");
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
