package com.maoniya.restful.api.security.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 定义REST API 返回数据格式
 *
 * date:  Created in 2018/9/28 14:34
 *
 * @author maoning
 */
public class ResponseModel<T> implements Serializable {

    private T data;

    private int code;

    private String message;

    /**
     * 请求成功且无返值
     */
    public ResponseModel() {
        this(null, HttpStatus.OK, "ok");
    }

    /**
     * 请求成功有返回值
     */
    public ResponseModel(T data) {
        this(data, HttpStatus.OK, "ok");
    }

    /**
     * 请求失败，无返回值，必须传入status和message
     * @param status
     * @param message
     */
    public ResponseModel(HttpStatus status, String message) {
        this(null, status, message);
    }

    private ResponseModel(T data, HttpStatus status, String message) {
        this.data = data;
        this.code = status.value();
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
