package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.objectsingle;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.ObjectSingle;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.ObjName;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun.Noun;

import java.util.LinkedList;
import java.util.List;

//情况四  (noun|ObjName) (De (noun|ObjName))?
public class ObjectSingle4 extends ObjectSingle {
    //这里的Object，只能为ObjName或者Noun
    public Node first; //第一个对象
    public List<Object> after = new LinkedList<>();//保存后面的对象
    @Override
    public boolean run(String methodName) {
        boolean res = true;
        Environment environment = EnvironmentConst.environment.get();
        if(first != null){
            boolean r = first.run(null);
            if(!r){
                return false;
            }
            BLObj blObj = environment.
                    findWithDelete(first instanceof ObjName ? ((ObjName)first).text : ((Noun)first).text);

            if(blObj == null){
                return false;
            }
            environment.add("宾语",blObj, BLObjType.BLObj, EnvironmentType.STACK);
        }

        for(int i=0;i<after.size();i++){
            Node second = (Node)after.get(i);
            boolean r = second.run(null);
            if(!r){
                return false;
            }
            BLObj blObj = environment.
                    findWithDelete(second instanceof ObjName ? ((ObjName)second).text : ((Noun)second).text);

            if(blObj == null){
                return false;
            }
            //这里用更新，来覆盖first那的宾语
            environment.update("宾语","宾语",blObj,BLObjType.BLObj, EnvironmentType.STACK);
        }

        return res;
    }
}
