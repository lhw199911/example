package com.example.common;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/05/03/17:53
 * @Description:
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    FAILED(500,"失败");

    private int code;
    private String message;

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
