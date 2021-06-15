package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment;

/**
 * 获取和存放语境的统一类
 * 设置成ThreadLocal是为了保证各剧本环境间相互隔离
 * 需要语境的时候通过 get set方法来获取
 *
 * 注意：机构环境和帮区环境是设置成为共同的了，所以可能会存在不同剧本一起操作的情况
 * 这些到后面进行优化
 */
public class EnvironmentConst {
    public static ThreadLocal<Environment> environment = new ThreadLocal<>();
}
