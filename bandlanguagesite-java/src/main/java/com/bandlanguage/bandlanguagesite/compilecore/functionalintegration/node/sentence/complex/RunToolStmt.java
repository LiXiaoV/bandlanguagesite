package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple.SimpleStmt4;

import java.util.List;

//执行工具句
public class RunToolStmt extends ComplexStmt {
    public SimpleStmt4 mainStmt; //主句
    public List<Compare> conditionList ; //可能附带的条件
    public SimpleStmt4 saveStmt; //可能附带的后句

    @Override
    public boolean run(String methodName) {
        return runTool();
    }

    /**
     * 在工具集成场景中，只有执行工具句型符合该结构，
     * 即mainStmt是执行工具，conditionList是参数赋值，saveStmt是取得的数据对象
     * @return
     */
    public boolean runTool(){
        Environment environment = EnvironmentConst.environment.get();
        boolean runRes = false;

        if(conditionList != null){
            JSONObject params = new JSONObject();
            for (Compare a : conditionList){
                runRes = a.run("changeMap");
                if(!runRes){
                    return false;
                }
                BLObj aRes = environment.findWithDelete("结果");
                //执行出错
                if(aRes == null){
                    return false;
                }else {
                    //合并参数map
                    JSONObject json = JSONObject.parseObject(aRes.value.toString());
                    params.putAll(json);
                }
            }
            environment.add("参数",params, BLObjType.RESULT_JSONOBJECT, EnvironmentType.STACK);
        }

        if(null != saveStmt){
            runRes = saveStmt.run(null);
            if(!runRes){
                return false;
            }
            BLObj aRes = environment.findWithDelete("结果");
            //执行出错
            if(aRes == null){
                return false;
            }else {
                environment.add("指定接口",aRes.value,aRes.type, EnvironmentType.STACK);
            }
        }

        //执行工具
        runRes = mainStmt.run(null);
        return runRes;
    }
}
