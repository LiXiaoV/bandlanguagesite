package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Adverbial;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Attribute;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;

public class PreposObj extends Adverbial {

    public PlaceAdv placeAdv;
    public Attribute attribute;
    public Obj obj;

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        if (placeAdv != null) {
            res = placeAdv.run(methodName);
            Environment.environment.put("PlaceAdv", Environment.environment.get("Adverbial"));
            Environment.environment.remove("Adverbial");
        }
        if (attribute != null) {
            res = attribute.run(methodName);
        }
        res = obj.run(methodName);
        Environment.environment.put("PrePos", Environment.environment.get("Object"));
        Environment.environment.remove("Object");
        return res;
    }
}
