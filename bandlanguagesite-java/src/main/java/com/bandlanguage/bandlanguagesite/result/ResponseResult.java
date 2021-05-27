package com.bandlanguage.bandlanguagesite.result;

import java.lang.annotation.*;


/**
 * Http响应内容统一封装的Annoation注解
 *
 * @author xiaov
 * @since 2021-04-19 15:29
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
}
