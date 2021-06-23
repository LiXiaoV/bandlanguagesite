package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.PlaceAdv;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.PreposObj;

public class Adverbial extends Element {

    public PlaceAdv placeAdv;
    public PreposObj preposObj;

    @Override
    public boolean run(String methodName) {
        boolean res = false;
        if (placeAdv != null) {
            res = placeAdv.run(methodName);

        }
        if (preposObj != null) {
            res = preposObj.run(methodName);
        }
        return res;
    }
}
