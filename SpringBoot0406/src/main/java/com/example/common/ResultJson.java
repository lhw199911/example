package com.example.common;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/05/03/17:51
 * @Description:
 */

@Getter
public class ResultJson {

    private int code;
    private String Message;
    private Object data;

    private ResultJson(int code, String message, Object data) {
        this.code = code;
        Message = message;
        this.data = data;
    }

    public static ResultJson success(String message, Object data) {
        return new ResultJson(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static ResultJson success(String message) {
        return new ResultJson(ResultCode.SUCCESS.getCode(), message, null);
    }

    public static ResultJson success(Object data) {
        return new ResultJson(ResultCode.SUCCESS.getCode(), null, data);
    }

    public static ResultJson failed(String message, Object data) {
        return new ResultJson(ResultCode.FAILED.getCode(), message, data);
    }

    public static ResultJson failed(String message) {
        return new ResultJson(ResultCode.FAILED.getCode(), message, null);
    }
}
