package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb;


//'设定'
public class Set  extends Verb{
    @Override
    public boolean run(String methodName) {
        return set();
    }

    /**
     * 暂时没有在简单句中用到
     * @return
     */
    private boolean set(){
        return false;
    }
}
