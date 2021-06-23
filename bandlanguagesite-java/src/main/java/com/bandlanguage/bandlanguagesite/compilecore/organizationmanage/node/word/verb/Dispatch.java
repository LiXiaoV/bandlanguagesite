package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Dispatch extends Verb {
    public String text;

    public Dispatch(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        if (object instanceof String) {
            switch (object.toString()) {
                case "部门":
                    System.out.println("派遣成员到部门");
                    break;
                case "子部门":
                    System.out.println("派遣成员到子部门");
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
