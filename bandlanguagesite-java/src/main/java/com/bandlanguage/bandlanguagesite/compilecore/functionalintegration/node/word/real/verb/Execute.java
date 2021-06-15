package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.Stmt;

import java.util.LinkedList;
import java.util.List;

//'执行'
public class Execute extends Verb {
    @Override
    public boolean run(String methodName) {
        Environment environment = EnvironmentConst.environment.get();
        BLObj obj = environment.findWithDelete("宾语");
        if(obj == null ){
            return false;
        }else {
            obj = (BLObj)obj.value;
        }
        //如果是设定的剧本
        if(obj.type == BLObjType.Node){
            try {
                Stmt script = (Stmt)obj.value;
                return script.run(null);
            }catch (Exception e){
                return false;
            }
        }

        //如果是工具ID
        if(obj.type == BLObjType.TOOLID){
            String toolID = obj.value.toString();
            //判断是否有设定参数
            BLObj params = environment.find("参数", EnvironmentType.STACK);
            JSONObject pa = null;
            if(params != null && params.type == BLObjType.RESULT_JSONOBJECT){
                pa = JSONObject.parseObject(params.value.toString());
            }
            //判断是否有设定具体执行哪些
            BLObj toolPart = environment.find("指定接口", EnvironmentType.STACK);
            LinkedList<String> to = new LinkedList<String>();
            if(toolPart != null){
                if(toolPart.type == BLObjType.RESULT_JSONARRAY){
                    //是数组，则表明指定了多个接口
                    JSONArray jsonArray = JSONArray.parseArray(toolPart.value.toString());
                    for (BLObj a : jsonArray.toJavaList(BLObj.class)){
                        if(a.type == BLObjType.RESULT_STRING){
                            //如果是string类型，则认为是指定的要获取的结果的名称
                            to.add(a.value.toString());
                        }
                    }
                }
                if(toolPart.type == BLObjType.RESULT_STRING){
                    //是字符串，则是仅指定一个
                    to.add(toolPart.value.toString());
                }

            }

            try {
                return runTool(toolID,pa,to);
            }catch (Exception e){
                return false;
            }
        }
        //如果是其他情况，暂时返回false
        return false;
    }

    /**
     * 根据工具ID和参数列表，执行工具，得到的结果先放在栈中
     * @param toolID 工具ID
     * @param params 参数列表
     * @param params 用户可能指定的具体接口
     * @return
     */
    public boolean runTool(String toolID, JSONObject params, List<String> toolPart){
        Environment environment = EnvironmentConst.environment.get();
        if(toolID.equals("专家查询工具") && params.containsKey("姓名")){
            //返回查询的专家列表
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("姓名","张三");
            a1.put("id","123");
            a1.put("所属机构","学校A");
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("姓名","张三1");
            a2.put("id","001");
            a2.put("所属机构","学校B");
            array.add(a2);

            JSONObject a3 = new JSONObject();
            a3.put("姓名","张三2");
            a3.put("id","002");
            a3.put("所属机构","学校C");
            array.add(a3);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }
        if(toolID.equals("专家查询工具") && params.containsKey("ID")){
            JSONObject a1 = new JSONObject();
            a1.put("姓名","张三");
            a1.put("id","123");
            a1.put("所属机构","学校A");
            JSONArray paper = new JSONArray();
            JSONObject p1 = new JSONObject();
            p1.put("标题","论文A标题");
            p1.put("链接","论文A链接");
            paper.add(p1);
            JSONObject p2 = new JSONObject();
            p2.put("标题","论文B标题");
            p2.put("链接","论文B链接");
            paper.add(p2);
            a1.put("论文成果",paper);
            environment.add(toolPart.get(0),a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);
            return true;
        }

        if(toolID.equals("论文查询工具") && params.containsKey("关键字")){
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("论文ID",1);
            a1.put("论文标题","论文A");
            a1.put("论文链接","论文A链接");
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("论文ID",2);
            a2.put("论文标题","论文B");
            a2.put("论文链接","论文B链接");
            array.add(a2);

            JSONObject a3 = new JSONObject();
            a3.put("论文ID",3);
            a3.put("论文标题","论文C");
            a3.put("论文链接","论文C链接");
            array.add(a3);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }

        if(toolID.equals("科技论文影响力指数查看工具") && params.containsKey("论文标题")){
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("论文标题","论文A");
            a1.put("被引量",27);
            a1.put("影响力",0);
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("论文标题","论文B");
            a2.put("被引量",12);
            a2.put("影响力",10);
            array.add(a2);

            JSONObject a3 = new JSONObject();
            a3.put("论文标题","论文C");
            a3.put("被引量",21);
            a3.put("影响力",12);
            array.add(a3);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }

        if(toolID.equals("论文参考文献评价分析工具") && params.containsKey("论文标题")){
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("论文标题","论文A");
            a1.put("参考文献得分",7);
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("论文标题","论文B");
            a2.put("参考文献得分",7);
            array.add(a2);

            JSONObject a3 = new JSONObject();
            a3.put("论文标题","论文C");
            a3.put("参考文献得分",5);
            array.add(a3);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }

        if(toolID.equals("消息通知工具") && params.containsKey("用户ID")){
            JSONObject a1 = new JSONObject();
            a1.put("发送结果","发送成功");
            environment.add(toolPart.get(0),a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);
            return true;
        }
        if(toolID.equals("绩效考核工具")){
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("员工ID",1);
            a1.put("配送快递数量",15);
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("员工ID",2);
            a2.put("配送快递数量",7);
            array.add(a2);

            JSONObject a3 = new JSONObject();
            a3.put("员工ID",3);
            a3.put("配送快递数量",12);
            array.add(a3);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }
        if(toolID.equals("快递管理工具")){
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("快递单号",1);
            a1.put("入库时间","2021-3-11");
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("快递单号",2);
            a2.put("入库时间","2021-3-9");
            array.add(a2);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }
        if(toolID.equals("任务分配工具") && params.containsKey("员工ID") && params.containsKey("快递单号")){
            JSONObject a1 = new JSONObject();
            a1.put("任务新建结果","成功");
            environment.add(toolPart.get(0),a1,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);
            return true;
        }

        if(toolID.equals("任务分配工具") && params.containsKey("员工ID")){
            JSONArray array = new JSONArray();
            JSONObject a1 = new JSONObject();
            a1.put("员工ID",1);
            a1.put("任务领取情况", JSONArray.parse("[{\"领取时间\":\"2021-3-17\",\"任务ID\":3},{\"领取时间\":\"2021-3-12\",\"任务ID\":1},{\"领取时间\":\"2021-3-14\",\"任务ID\":2}]"));
            array.add(a1);

            JSONObject a2 = new JSONObject();
            a2.put("员工ID",2);
            a2.put("任务领取情况", JSONArray.parse("[{\"领取时间\":\"2021-3-11\",\"任务ID\":4},{\"领取时间\":\"2021-3-1\",\"任务ID\":6},{\"领取时间\":\"2021-3-19\",\"任务ID\":5}]"));
            array.add(a2);
            environment.add(toolPart.get(0),array,BLObjType.RESULT_JSONARRAY,EnvironmentType.MEMORY);
            return true;
        }


        if(toolID.equals("摄像头工具")){
            environment.add(toolPart.get(0),"图像",BLObjType.RESULT_STRING,EnvironmentType.MEMORY);
            return true;
        }
        if(toolID.equals("人脸识别工具")){
            JSONObject a = new JSONObject();
            a.put("是否包含人脸",true);
            a.put("人脸数量",2);
            environment.add(toolPart.get(0),a,BLObjType.RESULT_JSONOBJECT,EnvironmentType.MEMORY);
            return true;
        }
        return false;
    }
}
