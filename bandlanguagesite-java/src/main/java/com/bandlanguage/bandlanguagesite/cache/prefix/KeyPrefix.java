package com.bandlanguage.bandlanguagesite.cache.prefix;

/**
 * 接口 -> 抽象类 -> 实现类
 * 实现根据各个模块划分key
 * @author xiaov
 * @since 2021-05-25 17:31
 */
public interface KeyPrefix {

    int expireSeconds();
    String getPrefix();
}
