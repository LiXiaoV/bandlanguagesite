package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;


import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Writer extends Noun {
    public String text;

    public Writer(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        Integer type = 2;//写者类型
        Environment.environment.put("Noun", type);
        return true;
    }
}
