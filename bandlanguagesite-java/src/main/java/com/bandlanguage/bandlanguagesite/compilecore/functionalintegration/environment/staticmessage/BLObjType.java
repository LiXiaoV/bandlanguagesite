package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * 记录词义的各类格式
 * 有：用户ID，工具ID，工具部件地址，机构ID，帮区ID，岗位ID，文档ID,各类工具返回结果
 */
public enum BLObjType {
    USERID("用户ID","string"),
    TOOLID("工具ID","string"),
    INTERFACEPLACE("工具调用地址","string"),
    ORGANIZATIONID("机构ID","string"),
    BANDID("帮区ID","string"),
    POST("岗位ID","string"),
    DOCUMENT("文档ID","string"),
    CHATROOM("聊天室ID","string"),
    RESULT_STRING("string类型的结果","string"),
    RESULT_INTEGER("int类型的结果","int"),
    RESULT_LIST("list类型的结果","List"),
    RESULT_BOOLEAN("boolean类型的结果","boolean"),
    RESULT_JSONOBJECT("jsonObject类型的结果","jsonObject"),
    RESULT_JSONARRAY("jsonArray类型的结果","jsonArray"),
    BLObj("语境对象","BLObj"),
    Node("帮语节点","node");

    private String mean;
    private String format;

    BLObjType(String mean, String format) {
        this.mean = mean;
        this.format = format;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 针对传入的数据，判断是哪种类型，并返回合适的枚举
     * 这里，不考虑吾托帮的各类ID，仅考虑一些基本类型
     * @param obj
     * @return
     */
    public static BLObjType get(Object obj){
        if(obj instanceof Integer){
            return RESULT_INTEGER;
        }
        if(obj instanceof Boolean){
            return RESULT_BOOLEAN;
        }
        if(obj instanceof String){
            return RESULT_STRING;
        }
        if(obj instanceof JSONArray){
            return RESULT_JSONARRAY;
        }
        if(obj instanceof List){
            return RESULT_LIST;
        }
        return null;
    }
}
