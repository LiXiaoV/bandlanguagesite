package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//'最大值'
public class Max extends Noun {
    @Override
    public boolean run(String methodName) {
        return min();
    }

    private boolean min(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.find("宾语");
        if(obj == null){
            return false;
        }else {
            obj = (BLObj)obj.value;
            if(obj.type != BLObjType.RESULT_LIST){
                return false;
            }
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
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else if(o1 == o2){
                    return 0;
                }else {
                    return 1;
                }

            }
        });
        environment.add(this.text,list.get(0), BLObjType.RESULT_INTEGER, EnvironmentType.STACK);
        return true;
    }
}
