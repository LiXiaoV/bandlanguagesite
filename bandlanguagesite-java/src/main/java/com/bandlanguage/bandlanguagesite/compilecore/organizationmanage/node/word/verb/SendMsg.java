package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class SendMsg extends Verb {
    public String text;

    public SendMsg(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        Object attribute = Environment.environment.get("Attribute");
        System.out.println("通知/发消息** ***");
        return res;
    }
}
