package com.maoniya.security.support;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * ResponseModel.java
 *
 * @author MaoNing
 * @version 1.0.0
 * @Date 2018/10/14 22:13
 */
public class ResponseModel<T> implements Serializable {

    private T data;

    private String code;

    private String message;

    public ResponseModel(HttpStatus status, T data, String message) {
        this.data = data;
        this.message = message;
        this.code = String.valueOf(status.value());
    }

    public static <T> ResponseModel<T> ok(T data) {
        return new ResponseModel<>(HttpStatus.OK, data, HttpStatus.OK.getReasonPhrase());
    }

    public static <T> ResponseModel<T> error(HttpStatus status) {
        return error(status, status.getReasonPhrase());
    }

    public static <T> ResponseModel<T> error(HttpStatus status, String message) {
        return new ResponseModel<>(status, null, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
