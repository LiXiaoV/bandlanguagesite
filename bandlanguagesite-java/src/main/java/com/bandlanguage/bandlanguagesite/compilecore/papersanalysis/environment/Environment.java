package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.environment;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Environment {

    public static Map<String, Object> environment = new HashMap<>();
    public static Stack envStack = new Stack();
    static {
        JSONObject jo = new JSONObject();
        jo.put("test", "test");
        environment.put("Num", jo);
        environment.put("sceneName", "论文分析");
    }
}
