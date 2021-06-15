package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;

import java.util.List;
import java.util.Map;

//句子结构的基本父类
public class Element implements Node {
    public String text;//剧本内容

    @Override
    public boolean run(String methodName) {
        return false;
    }

    @Override
    public void checkSelf(Map<String, List<Object>> nodes) {

    }
}
