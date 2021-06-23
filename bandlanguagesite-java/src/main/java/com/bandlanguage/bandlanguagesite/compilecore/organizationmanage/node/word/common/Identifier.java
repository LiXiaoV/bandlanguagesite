package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;

public class Identifier extends Word {

    public String text;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object o = Environment.environment.get(text);
        if (o == null || o.toString().equals("")) {
            System.out.println("从语境获取失败");
            res = false;
        } else {
            Environment.environment.put("Identifier", o);
        }
        return res;
    }
}
