package com.rayclould.anonymousarea.core.constant;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

public enum CodeConst {
    /**
     * success
     */
    SUCCESS(200, "成功"),
    NOT_FOUNT(404, "找不到"),
    PRIMARY_KEY_ISNULL(991, "主键不能为空"),
    REPEAT(992, "数据重复"),
    CodeOR(993, "系统错误"),
    ADMIN_USER_REPEAT(994, "后台用户名重复"),
    NULL_DATA(995, "没有数据"),
    TIME_PASSED(996, "时间己过期"),
    USER_NOT_FOUND(997, "找不到用户"),
    USER_REPEAT(998, "用户重复"),
    AUTH_FAILED(999, "用户名或密码错误");


    private int resultCode;
    private String message;

    CodeConst(int resultCode) {
        this.resultCode = resultCode;
    }

    CodeConst(String message) {
        this.message = message;
    }

    CodeConst(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
