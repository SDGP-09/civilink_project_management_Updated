package com.civilink.civilink_project_management.util;

import org.springframework.stereotype.Component;

public class StandardResponse {
    private int Code;
    private String message;
    private Object data;

    public StandardResponse(int code, String message, Object data) {
        this.Code = code;
        this.message = message;
        this.data = data;
    }

    public StandardResponse() {
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
