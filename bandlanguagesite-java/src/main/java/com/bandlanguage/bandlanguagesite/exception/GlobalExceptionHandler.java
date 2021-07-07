package com.bandlanguage.bandlanguagesite.exception;

import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-25 16:51
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return Result.fail(ex.getResultCode());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);

            String msg = error.getDefaultMessage();
            return Result.fail(500, "BindException:" + msg);
        } else if(e instanceof  FormatException){
            return Result.fail(1003,"FormatException"+e.getMessage());
        } else {
            return Result.fail(ResultCode.SERVER_ERROR);
        }
    }
}
