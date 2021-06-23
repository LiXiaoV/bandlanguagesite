package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Adverbial;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;

public class PlaceAdv extends Adverbial {

    public Obj obj;

    @Override
    public boolean run(String methodName) {
        boolean res = false;
        res = obj.run(methodName);
        if (res) {
            Environment.environment.put("Adverbial", Environment.environment.get("Object"));
            Environment.environment.remove("Object");
        }
        return res;
    }
}
