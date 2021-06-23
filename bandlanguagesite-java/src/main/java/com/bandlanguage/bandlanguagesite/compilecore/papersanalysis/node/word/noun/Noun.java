package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.noun;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.Word;

public class Noun extends Word {

    @Override
    public boolean run(String methodName) {
        Environment.environment.put("Noun", super.text);
        return true;
    }
}
