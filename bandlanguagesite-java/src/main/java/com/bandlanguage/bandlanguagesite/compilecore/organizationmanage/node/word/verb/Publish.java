package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;

public class Publish extends Verb {
    public String text;

    public Publish(String text) {
        this.text = text;
    }

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Object object = Environment.environment.get("Object");
        if (Environment.environment.get("Adverbial") != null) {
            Object adverbial = Environment.environment.get("Adverbial");
            System.out.println("把**发布到**");
        } else {
            Object attribute = Environment.environment.get("Attribute");
            System.out.println("发布给** ***");
        }
        return res;
    }
}
