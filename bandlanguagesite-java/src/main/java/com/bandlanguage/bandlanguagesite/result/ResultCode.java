package com.bandlanguage.bandlanguagesite.result;

/**
 * @author xiaov
 * @since 2021-04-19 14:43
 */
public enum ResultCode {

    EXCEPTION(201, "未知异常"),
    RUNTIME_EXCEPTION(202, "运行时异常"),
    NULL_POINTER_EXCEPTION(203, "空指针异常"),
    CLASS_CAST_EXCEPTION(204, "类型转换异常"),
    IO_EXCEPTION(205, "IO异常"),
    SYSTEM_EXCEPTION(210, "系统异常"),
    NOT_FOUND(404, "Not Found"),
    /**
     * 参数错误：1001 - 1999
     */
    PARAMS_IS_INVALID(1001, "参数无效"),
    PARAMS_IS_BLANK(1002, "参数为空"),
    PARAMS_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAMS_NOT_COMPLETE(1004, "参数缺失"),

    /**
     * 用户错误：2001 - 2999
     */
    USER_NOT_LOGGED_IN(2001,"用户未登录，访问路径需要验证，请登录"),
    USER_NOT_LOGIN_ERROR(2002,"用户不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003,"用户被禁用"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在"),
    USER_IS_EXPIRED(2006,"用户账号已过期"),
    USER_FIRST_LANDING(2007, "首次登录"),
    USER_TOKEN_EXPIRED(2008,"Token过期"),
    USER_TOKEN_GENERTATION_FAIL(2009,"生成Token失败"),
    USER_SIGN_VERIFI_NOT_COMPLIANT(2010,"签名校验不合规"),
    USER_PASSWORD_RESET_FAILED(2011, "重置密码失败"),
    USER_UNKONWN_INDENTITY(2012, "未知身份"),
    MANY_USER_LOGINS(2111,"多用户在线"),
    TOO_MANY_PASSWD_ENTER(2112, "密码输入次数过多"),
    VERIFICATION_CODE_INCORECT(2202,"图形验证码不正确"),
    VERIFICATION_CODE_FAIL(2203,"图形验证码生产失败"),

    /**
     * 3000～3999 区间表示接口异常
     */
    API_EXCEPTION(3000, "接口异常"),
    API_NOT_FOUND_EXCEPTION(3002, "接口不存在"),
    API_REQ_MORE_THAN_SET(3003, "接口访问过于频繁，请稍后再试"),
    API_IDEMPOTENT_EXCEPTION(3004, "接口不可以重复提交，请稍后再试"),
    API_PARAM_EXCEPTION(3005, "参数异常"),
    API_PARAM_MISSING_EXCEPTION(3006, "缺少参数"),
    API_METHOD_NOT_SUPPORTED_EXCEPTION(3007, "不支持的Method类型"),
    API_METHOD_PARAM_TYPE_EXCEPTIION(3008, "参数类型不匹配"),

    ARRAY_EXCEPTION(11001, "数组异常"),
    ARRAY_OUT_OF_BOUNDS_EXCEPTION(11002, "数组越界异常"),

    JSON_SERIALIZE_EXCEPTION(30000, "序列化数据异常"),
    JSON_DESERIALIZE_EXCEPTION(30001, "反序列化数据异常"),

    READ_RESOURSE_EXCEPTION(31002, "读取资源异常"),
    READ_RESOURSE_NOT_FOUND_EXCEPTION(31003, "资源不存在异常"),

    DATA_EXCEPTION(32004, "数据异常"),
    DATA_NOT_FOUND_EXCEPTION(32005, "未找到符合条件的数据异常"),
    DATA_CALCULATION_EXCEPTION(32006, "数据计算异常"),
    DATA_COMPRESS_EXCEPTION(32007, "数据压缩异常"),
    DATA_DE_COMPRESS_EXCEPTION(32008, "数据解压缩异常"),
    DATA_PARSE_EXCEPTION(32009, "数据转换异常"),

    ENCODING_EXCEPTION(33006, "编码异常"),
    ENCODING_UNSUPPORTED_EXCEPTION(33006, "编码不支持异常"),

    DATE_PARSE_EXCEPTION(34001, "日期转换异常"),


    MAILE_SEND_EXCEPTION(35001, "邮件发送异常"),

    SERVER_ERROR(500100,"服务端异常"),

    // 用户模块 5002XX
    SESSION_ERROR(500201,"Session不存在或者已经失效"),
    USERNAME_EMPTY(50002,"用户名不能为空"),
    USERNAME_NOT_EXIST(500203,"用户名不存在"),
    MOBILE_EMPTY(500204,"手机号码不能为空"),
    MOBILE_ERROR(500205,"手机号码格式错误"),
    MOBILE_NOT_EXIST(500206,"手机号不存在"),
    EMAIL_EMPTY(500207,"邮箱号不能为空"),
    EMAIL_ERROR(500208,"邮箱号格式错误"),
    EMAIL_NOT_EXIST(500209,"邮箱号不存在"),
    PASSWORD_ERROR(500210,"密码错误"),
    VISITOR_NEED_NOT_LOGIN(500211,"游客无需登陆"),
    REGISTER_USERNAME_EXIST(500212,"注册用户名已存在"),
    REGISTER_MOBILE_EXISTZ(500213,"注册电话号码已存在"),
    REGISTER_EMAIL_EXIST(500214,"注册邮箱已存在"),

    // 词汇模块 5003XX
    DELETE_WORD_NOT_EXIST(500301,"要删除的词汇不存在"),
    /**
     * 成功状态码
     */
    SUCCESS(0, "success"),

    /** 失败 **/
    FAILURE(500,"failure");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
