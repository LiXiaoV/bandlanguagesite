package com.bandlanguage.bandlanguagesite.service;

/**
 * @author xiaov
 * @since 2021-06-15 10:13
 */
public interface BLService {

    /**
     * 获得某剧本的语法树
     *
     * @param script  剧本
     * @return 语法树字符串
     */
    String getAST(String script);

    /**
     * 运行剧本
     *
     * @param script  剧本
     * @return 运行剧本的结果
     */
    Object runScript(String script);
}
