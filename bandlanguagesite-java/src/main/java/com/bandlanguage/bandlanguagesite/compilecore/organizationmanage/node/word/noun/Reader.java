package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Reader extends Noun {
    public String text;

    public Reader(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        Integer type = 1;//读者类型
        Environment.environment.put("Noun", type);
        return true;
    }
}
