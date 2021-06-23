package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Have extends Verb {
    public String text;

    public Have(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object subject = Environment.environment.get("Subject");
        Object adverbial = Environment.environment.get("Adverbial");
        Object attribute = Environment.environment.get("Attribute");
        Object obj = Environment.environment.get("Object");
        if (subject != null && adverbial != null && attribute != null && obj != null) {
            switch (obj.toString()) {
                case "角色":
                    System.out.println("要拥有的角色类型" + attribute.toString());
                    break;
                default:
                    res = false;
                    break;
            }
        } else {
            res = false;
        }
        return res;
    }
}
