package com.bandlanguage.bandlanguagesite.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 异常响应的返回信息实体
 *
 * @author xiaov
 * @since 2021-04-19 16:27
 */
@Data
public class ErrorResult implements Serializable {
    private static final long serialVersionUID = -4505655308965878999L;

    /**
     * 错误编码
     */
    private Integer code;

    /**
     * 消息描述
     */
    private String message;

    /**
     * 错误
     */
    private String exception;

    public static ErrorResult fail(Integer code, String message) {
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(code);
        errorResult.setMessage(message);
        return errorResult;
    }

    public static ErrorResult fail(ResultCode resultCode, Throwable e) {
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(resultCode.getCode());
        errorResult.setMessage(errorResult.message);
        errorResult.setException(e.getClass().getName());
        return errorResult;
    }

    public static ErrorResult fail(ResultCode resultCode, Throwable e, String message) {
        ErrorResult errorResult = ErrorResult.fail(resultCode, e);
        errorResult.setMessage(message);
        return errorResult;
    }
}
