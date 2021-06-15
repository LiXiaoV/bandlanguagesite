package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.empty;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.Word;

//虚词，不做任何操作
public class EmptyWord extends Word {

    @Override
    public boolean run(String methodName) {
        return true;
    }
}
