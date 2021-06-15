package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.environment;

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
        environment.put("organizationId", 304065146L);
        environment.put("华南理工大学B8科研实验室", 304065146L);
        environment.put("测试开发部", 314539425L);
        environment.put("张志斌", 4386720L);
        environment.put("实习生", 314543309L);
    }
}
