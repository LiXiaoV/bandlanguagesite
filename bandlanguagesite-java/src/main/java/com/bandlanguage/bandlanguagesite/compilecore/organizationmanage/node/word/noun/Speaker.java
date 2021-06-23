package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Speaker extends Noun {

    public String text;

    public Speaker(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        Integer type = 0;//言者类型
        Environment.environment.put("Noun", type);
        return true;
    }
}
