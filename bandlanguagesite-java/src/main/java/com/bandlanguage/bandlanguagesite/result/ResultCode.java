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
    SAVE_WORD_FAIL(500301,"保存词汇失败"),
    SELECT_WORD_NOT_EXIST(500302,"要查询的词汇不存在"),
    EDIT_WORD_FAIL(500303,"修改词汇失败"),
    DELETE_WORD_NOT_EXIST(500304,"要删除的词汇不存在"),
    UPDATE_SCENE_WORD_FAIL(500305,"更新场景区-词汇关联表失败"),
    UPDATE_WORD_USER_FAIL(500306,"更新词汇-用户关联表失败"),
    SAVE_SCENE_WORD_FAIL(500307,"保存场景区-词汇关联表的记录失败"),
    SAVE_WORD_USER_FAIL(500308,"保存词汇-用户关联表的记录失败"),

    // 句型模块 5004XX
    SAVE_SENTENCE_FAIL(500401,"保存句型失败"),
    SELECT_SENTENCE_NOT_EXIST(500402,"要查询的句型不存在"),
    EDIT_SENTENCE_FAIL(500403,"修改句型失败"),
    DELETE_SENTENCE_NOT_EXIST(500404,"要删除的句型不存在"),
    UPDATE_SCENE_SENTENCE_FAIL(500405,"更新场景区-句型关联表失败"),
    UPDATE_SENTENCE_USER_FAIL(500406,"更新句型-用户关联表失败"),
    SAVE_SCENE_SENTENCE_FAIL(500407,"保存场景区-句型关联表的记录失败"),
    SAVE_SENTENCE_USER_FAIL(500408,"保存句型-用户关联表的记录失败"),
    SAVE_PARADIGM_FAIL(500409,"保存中间范式失败"),
    SELECT_PARADIGM_NOT_EXIST(500410,"要查询的中间范式不存在"),
    DELETE_PARADIGM_NOT_EXIST(500411,"要删除的中间范式不存在"),
    DELETE_PARADIGM_FAIL(500412,"删除中间范式失败"),
    UPDATE_PARADIGM_FAIL(500413,"修改中间范式失败"),
    UPDATE_PARADIGM_NOT_EXIST(500414,"要修改的中间范式不存在"),

    // 剧本模块 5005XX
    SAVE_SCRIPT_FAIL(500501,"保存剧本失败"),
    SELECT_SCRIPT_NOT_EXIST(500502,"要查询的剧本不存在"),
    EDIT_SCRIPT_FAIL(500503,"修改剧本失败"),
    DELETE_SCRIPT_NOT_EXIST(500504,"要删除的剧本不存在"),
    UPDATE_SCENE_SCRIPT_FAIL(500505,"更新场景区-剧本关联表失败"),
    UPDATE_SCRIPT_USER_FAIL(500506,"更新剧本-用户关联表失败"),
    SAVE_SCENE_SCRIPT_FAIL(500507,"保存场景区-剧本关联表的记录失败"),
    SAVE_SCRIPT_USER_FAIL(500508,"保存剧本-用户关联表的记录失败"),
    EDIT_SCRIPT_NOT_EXIST(500509,"要修改的剧本不存在"),
    INCREASE_SCRIPT_RUNTIMES_FAIL(500510,"增加剧本运行次数失败"),

    // 规则模块 5006XX
    SAVE_RULE_FAIL(500601,"保存规则失败"),
    SAVE_SCENE_RULE_FAIL(500602,"保存场景区-规则关联表的记录失败"),
    SAVE_RULE_USER_FAIL(500603,"保存规则-用户关联表的记录失败"),
    SAVE_WORD_RULE_FAIL(500604,"保存规则-词汇关联表的记录失败"),
    SAVE_SENTENCE_RULE_FAIL(500605,"保存规则-句型关联表的记录失败"),
    UPDATE_RULE_USER_FAIL(500606,"更新规则-用户关联表的记录失败"),
    UPDATE_RULE_FAIL(500607,"更新规则失败"),
    UPDATE_WORD_RULE_FAIL(500608,"更新规则-词汇关联表的记录失败"),
    UPDATE_SENTENCE_RULE_FAIL(500609,"更新规则-句型关联表的记录失败"),
    DELETE_WORD_RULE_FAIL(500610,"删除规则-词汇关联表的记录失败"),
    DELETE_SENTENCE_RULE_FAIL(500611,"删除规则-句型关联表的记录失败"),
    SELECT_RULE_NOT_EXIST(500612,"要查询的规则不存在"),
    DELETE_RULE_NOT_EXIST(500613,"要删除的规则不存在"),
    DELETE_RULE_FAIL(500614,"删除规则失败"),
    DELETE_SCENE_RULE_FAIL(500615,"删除场景区-规则关联表的记录失败"),
    DELETE_RULE_USER_FAIL(500616,"删除规则-用户关联表的记录失败"),

    // 节点模块 5007XX
    SAVE_NODE_FAIL(500701,"保存节点失败"),
    SAVE_SCENE_NODE_FAIL(500702,"保存场景区-节点关联表的记录失败"),
    SAVE_NODE_USER_FAIL(500703,"保存节点-用户关联表的记录失败"),
    SAVE_WORD_NODE_FAIL(500704,"保存节点-词汇关联表的记录失败"),
    SAVE_SENTENCE_NODE_FAIL(500705,"保存节点-句型关联表的记录失败"),
    UPDATE_NODE_USER_FAIL(500706,"更新节点-用户关联表的记录失败"),
    UPDATE_NODE_FAIL(500707,"更新节点失败"),
    UPDATE_WORD_NODE_FAIL(500708,"更新节点-词汇关联表的记录失败"),
    UPDATE_SENTENCE_NODE_FAIL(500709,"更新节点-句型关联表的记录失败"),
    DELETE_WORD_NODE_FAIL(500710,"删除节点-词汇关联表的记录失败"),
    DELETE_SENTENCE_NODE_FAIL(500711,"删除节点-句型关联表的记录失败"),
    SELECT_NODE_NOT_EXIST(500712,"要查询的节点不存在"),
    DELETE_NODE_NOT_EXIST(500713,"要删除的节点不存在"),
    DELETE_NODE_FAIL(500714,"删除节点失败"),
    DELETE_SCENE_NODE_FAIL(500715,"删除场景区-节点关联表的记录失败"),
    DELETE_NODE_USER_FAIL(500716,"删除节点-用户关联表的记录失败"),

    // 场景区模块 5007XX
    SAVE_SCENE_FAIL(500801,"保存场景区失败"),
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
