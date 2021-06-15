package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.ComplexStmt;

//执行工具句
public class RunToolStmt0 extends ComplexStmt {
    public String  objName; //参数对象名称
    public String toolName ; //工具名称
    public String interfaceName; //接口列表

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
        if(objName.equals("论文标题集合")){
            //是去查影响力
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("论文标题","论文A标题");
            a1.put("被引量",10);
            a1.put("影响力",7);
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("论文标题","论文B标题");
            a2.put("被引量",2);
            a2.put("影响力",0);
            array.add(a2);

            environment.add("查询接口",array, BLObjType.RESULT_JSONARRAY, EnvironmentType.MEMORY);
            return true;
        }
        if(objName.equals("当前图像")){
            //是去查影响力
            JSONObject a1 = new JSONObject();
            a1.put("是否包含人脸",true);
            a1.put("人脸数量",2);
            environment.add("识别结果",a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);
            return true;
        }
        return false;
    }
}
