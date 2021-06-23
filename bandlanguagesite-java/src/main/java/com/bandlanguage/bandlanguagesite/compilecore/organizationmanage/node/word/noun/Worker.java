package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Worker extends Noun {

    public String text;

    public Worker(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        Integer type = 3;//工者类型
        Environment.environment.put("Noun", type);
        return true;
    }
}
