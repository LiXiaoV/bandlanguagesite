package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//'平均值'
public class Average extends Noun {

    @Override
    public boolean run(String methodName) {
        return avg();
    }

    private boolean avg(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.find("宾语");
        if(obj == null || obj.type != BLObjType.BLObj){
            return false;
        }
        obj = (BLObj)obj.value;
        if(obj == null || obj.type != BLObjType.RESULT_LIST){
            return false;
        }
        List<Integer> list = new LinkedList<>();

        //判断是否是数字列表
        if (obj.value instanceof ArrayList<?>) {
            try {
                list = (List<Integer>) obj.value;
            }catch (Exception e){
                //不能转换为数字
                return false;
            }
        }else {
            return false;
        }
        int total = 0;
        for(Integer a : list){
            total += a;
        }
        total = total/list.size();
        environment.add(this.text,total, BLObjType.RESULT_INTEGER, EnvironmentType.STACK);
        return true;
    }

}
