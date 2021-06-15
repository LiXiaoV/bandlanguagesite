package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node;

import java.util.List;
import java.util.Map;

//树节点的最基本的接口
public interface Node {
    /**
     * 节点对外的统一执行方法
     * @param methodName 需要执行的方法的名称
     * @return 返回的值表示该节点是否执行成功
     */
     boolean run(String methodName);

    /**
     * 检测当前节点是否有二义性，如果有，则放到nodes中
     * @param nodes 存放那些具有二义性的节点 key是对应中文,value是它所有的执行方法
     */
    void checkSelf(Map<String, List<Object>> nodes);
}
