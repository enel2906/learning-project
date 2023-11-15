package org.example.app.response.user;

import org.example.app.response.ResponseData;

public class SigninResponse extends ResponseData {
    private int code;
    private String message;
    private String notification;

    public SigninResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public SigninResponse(String notification) {
        this.notification = notification;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
