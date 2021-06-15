package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.Obj;

import java.util.ArrayList;
import java.util.List;

public class ObjWithObj extends Obj {

    public List<Obj> objList = new ArrayList<>();

    @Override
    public boolean run(String methodName) {
        boolean res = true;
        List<Long> lists = new ArrayList<>();
        for (int i = 0; i < objList.size(); i++) {
            if (res) {
                res = objList.get(i).run(methodName);
                lists.add(Long.valueOf(Environment.environment.get("Object").toString()));
                Environment.environment.remove("Object");
            }
        }
        Environment.environment.put("ObjWithObj", lists);
        return res;
    }
}
