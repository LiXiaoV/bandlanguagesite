package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Join extends Verb {

    public String text;

    public Join(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Attribute");
        if (object instanceof String) {
            switch (object.toString()) {
                case "成员":
                    System.out.println("添加成员");
                    Environment.envStack.push("addUsersToDepartment");
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
