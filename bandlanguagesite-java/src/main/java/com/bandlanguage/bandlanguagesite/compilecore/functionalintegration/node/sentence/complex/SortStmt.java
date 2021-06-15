package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//排序句
public class SortStmt extends ComplexStmt {
    public String para; //属性名称
    public String objName; //对象名称
    public int type; //排序类型 -1为升序  1为降序

    @Override
    public boolean run(String methodName) {
        return sort();
    }

    public boolean sort(){
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.find(objName);
        //数据不存在或者不是数组、集合
        if(null == obj || obj.type != BLObjType.RESULT_JSONARRAY){
            return false;
        }
        JSONArray array = JSONArray.parseArray(obj.value.toString());

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < array.size(); i++) {
            jsonValues.add(array.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                Object ap = a.get(para);
                Object bp = b.get(para);

                //是否为空判断
                if(ap == null){
                    if(bp == null){
                        return 0;
                    }else {
                        return type<0? 1 : -1;
                    }
                }

                if(bp == null){
                    return type<0? -1 : 1;
                }

                if(ap instanceof Integer && bp instanceof Integer){
                    Integer ai = Integer.parseInt(ap.toString());
                    Integer bi = Integer.parseInt(bp.toString());
                    return type<0? ai.compareTo(bi) : bi.compareTo(ai);
                }

                String as = ap.toString();
                String bs = bp.toString();
                return type<0? as.compareTo(bs) : bs.compareTo(as);

            }
        });

        obj.value = jsonValues;

        return true;
    }
}
