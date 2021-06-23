package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Edit extends Verb {
    public String text;

    public Edit(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object attribute = Environment.environment.get("Attribute");
        Object prepos = Environment.environment.get("PrePos");
        Object obj = Environment.environment.get("Object");
        if (attribute == null) {
            System.out.println("原岗位错误");
            res = false;
        } else {
            switch (prepos.toString()) {
                case "部门":
                    System.out.println("修改部门");
                    break;
                case "岗位":
                    System.out.println("修改岗位");
                    break;
                default:
                    res = false;
                    break;
            }
        }
        return res;
    }
}
