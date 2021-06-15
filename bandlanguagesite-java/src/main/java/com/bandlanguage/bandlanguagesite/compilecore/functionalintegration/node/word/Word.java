package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;

import java.util.List;
import java.util.Map;

//词的基本父类
public class Word implements Node {
    public String text; //剧本中的词

    @Override
    public boolean run(String methodName) {
        return false;
    }

    @Override
    public void checkSelf(Map<String, List<Object>> nodes) {

    }
}
