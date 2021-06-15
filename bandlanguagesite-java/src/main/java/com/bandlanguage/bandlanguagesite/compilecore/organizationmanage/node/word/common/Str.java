package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;

public class Str extends Word {

    public String text;

    @Override
    public boolean run(String methodName) {
        Environment.environment.put("Str", text.replace("‘", "").replace("’", ""));
        return true;
    }
}
