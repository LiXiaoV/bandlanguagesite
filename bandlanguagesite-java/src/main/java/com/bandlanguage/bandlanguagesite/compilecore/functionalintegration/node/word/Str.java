package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;

//字符串
public class Str extends Word {
    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        String word = this.text.substring(1,this.text.length()-1);
        environment.add(this.text,word, BLObjType.RESULT_STRING, EnvironmentType.STACK);
        return true;
//
//        if(this.text. charAt(0) == '‘' && this.text.charAt(this.text.length()-1) == '’'){
//            //如果是被中文单引号包含，则认为是取字符串本身
//
//        }
//        BLObj blObj = environment.find(this.text);
//        if(blObj == null){
//            environment.showForUser.add("在语境中未找到:"+this.text);
//            return false;
//        }else {
//            environment.add(this.text,blObj.value,blObj.type, EnvironmentType.STACK);
//            return true;
//        }
    }
}
