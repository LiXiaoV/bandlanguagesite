package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Establish extends Verb {

    public String text;

    public Establish(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        if (object instanceof String) {
            switch (object.toString()) {
                case "部门":
                    System.out.println("创建部门");
                    Environment.envStack.push("createDepartment");
                    break;
                case "子部门":
                    System.out.println("创建子部门");
                    Environment.envStack.push("createDepartment");
                    break;
                case "岗位":
                    System.out.println("创建岗位");
                    Environment.envStack.push("createPosition");
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
