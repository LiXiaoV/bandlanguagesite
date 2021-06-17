package com.bandlanguage.bandlanguagesite.exception;

import com.bandlanguage.bandlanguagesite.result.ResultCode;

/**
 * @author xiaov
 * @since 2021-05-25 16:48
 */
public class GlobalException extends RuntimeException {

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public GlobalException(ResultCode resultCode) {
        super(resultCode.toString());
        this.resultCode = resultCode;
    }
}
