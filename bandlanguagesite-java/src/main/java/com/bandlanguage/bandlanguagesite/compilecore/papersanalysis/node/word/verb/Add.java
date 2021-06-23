package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.environment.Environment;

/**
 * 添加
 *
 * @author xiaov
 * @since 2021-06-11 16:51
 */
public class Add extends Verb {
    public String text;

    public Add(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        if (object instanceof String) {
            switch (object.toString()) {
                case "论文":
                    System.out.println("添加论文");
//                    Environment.envStack.push("createDepartment");
                    break;
                case "摘要":
                    System.out.println("添加摘要");
//                    Environment.envStack.push("createDepartment");
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
