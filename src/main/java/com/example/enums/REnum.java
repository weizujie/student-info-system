package com.example.enums;

/**
 * Http返回信息枚举
 */
public enum REnum {

    UNKNOWN_ACCOUNT(1, "用户不存在"),

    PARAM_ERROR(2, "参数不正确"),

    ACCOUNT_EXIST(3, "该账号已存在"),

    USERNAME_OR_PASSWORD_ERROR(4, "用户名或密码错误"),

    ACCOUNT_DISABLE(5, "账号已被禁用"),

    AUTH_ERROR(6, "账户验证失败"),

    NOT_LOGIN(7, "未登录"),

    NOT_PERMISSION(8, "您没有访问该功能的权限"),

    GAMELEVEL_EXIST(9, "该赛事等级已存在"),

    RACENAME_EXIST(10, "该赛事已存在"),

    RACESCOPE_EXITS(11, "该赛事范围已存在");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    REnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
