package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;

//设定句
public class SetStmt extends ComplexStmt {
    public String mainString; //术语
    public Object value; //值
    public SetValueEnum enumType; //类型

    @Override
    public boolean run(String methodName) {
        return setStmt();
    }

    public boolean setStmt(){
        Environment environment = EnvironmentConst.environment.get();
        if(enumType==SetValueEnum.OBJ){
            B_Object node = (B_Object)value;
            node.run(null);
            BLObj va = environment.findWithDelete("宾语");
            va = (BLObj)va.value;
            environment.add(mainString,va.value,va.type, EnvironmentType.MEMORY);
            return true;
        }
        environment.add(mainString,value,enumType.getType(), EnvironmentType.MEMORY);
        return true;
    }
}
