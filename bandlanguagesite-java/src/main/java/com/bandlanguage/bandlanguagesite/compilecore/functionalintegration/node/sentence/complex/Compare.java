package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.SimpleStmt;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.compare.CompareWord;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.compare.Equals;

//比较句
public class Compare extends SimpleStmt {
    public B_Object first;
    public B_Object second;
    public CompareWord compare;


    @Override
    public boolean run(String methodName) {
        String runMethod = "";
        if(null == methodName || methodName.length()==0){  //如果没有传入方法名称
            Environment environment = EnvironmentConst.environment.get();
            runMethod = environment.methodChoosed.poll();
            //没有指定方法
            if(null == runMethod){
                return false;
            }
        }else {
            runMethod = methodName;
        }
        switch (runMethod){
            case "compare":
                return compare();
            case "changeMap":
                return changeMap();
            default:
                return false;
        }
    }

    /**
     * 进行正式的比较，会得到一个比较结果，将其放在stack中
     * @return
     */
    public boolean compare(){
        boolean res = true;
        Environment environment = EnvironmentConst.environment.get();
        res = first.run(null);
        //执行失败
        if(!res){
            return false;
        }

        BLObj left = environment.find("宾语", EnvironmentType.STACK);
        res = environment.update("宾语","左值",left.value,left.type,EnvironmentType.STACK);
        //数据更新失败
        if(!res){
            return false;
        }

        res = second.run(null);
        //执行失败
        if(!res){
            return false;
        }

        BLObj right = environment.find("宾语",EnvironmentType.STACK);
        res = environment.update("宾语","右值",right.value,right.type,EnvironmentType.STACK);
        //数据更新失败
        if(!res){
            return false;
        }

        return compare.run(null);
    }

    /**
     * 在工具集成场景下，调用工具的时候需要指定参数，如姓名=张三
     * 故该函数的功能是将这个比较句转转换为一个map key 是参数名称,value 是值
     * map最终存放在语境中
     * @return
     */
    public boolean changeMap(){
        //判断是不是‘等于’，如果不是，则不是执行工具句型中的参数赋值，不执行
        if(!(compare instanceof Equals)){
            return false;
        }

        Environment environment = EnvironmentConst.environment.get();
        JSONObject object = new JSONObject();
        boolean getValue = second.run(null);
        //执行失败
        if(!getValue){
            return false;
        }
        BLObj right = environment.findWithDelete("宾语");
        object.put(first.text,((BLObj)right.value).value);
        environment.add("结果",object, BLObjType.RESULT_JSONOBJECT,EnvironmentType.STACK);
        return true;
    }

}
