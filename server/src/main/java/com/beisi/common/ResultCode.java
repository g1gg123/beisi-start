package com.beisi.common;


/**
 * 状态码枚举
 */
public enum ResultCode {
    SUCCESS(0, "Login successful"),
    ERROR(1, "Invalid username or password");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
