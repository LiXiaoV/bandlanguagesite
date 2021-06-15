package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;

import java.util.List;
import java.util.Map;

public class Script implements Node {
    public List<Stmt> lists;

    public String text;

    /**
     * 剧本的执行，有两种选择，默认为continueWhenError
     * @param methodName 需要执行的方法的名称
     * @return
     */
    @Override
    public boolean run(String methodName) {
        if("stopWhenError".equals(methodName)){
            return stopWhenError();
        }
        return continueWhenError();
    }

    /**
     * 剧本节点执行方法一
     * 有句子执行失败则停止
     * @return 停止了则返回false，否则为true
     */
    public boolean stopWhenError(){
        Environment environment = EnvironmentConst.environment.get();
        for (Stmt a : lists){
            boolean res = a.run(null);
            environment.cleanStack(); //在执行完成后，清空栈
            if(!res){
                return false;
            }
        }
        return true;
    }

    /**
     * 剧本节点执行方法二
     * 有句子执行失败,也继续执行
     * @return
     */
    public boolean continueWhenError(){
        Environment environment = EnvironmentConst.environment.get();
        for (Stmt a : lists){
            a.run(null);
            environment.cleanStack(); //在执行完成后，清空栈
        }
        return true;
    }

    @Override
    public void checkSelf(Map<String, List<Object>> nodes) {

    }
}
