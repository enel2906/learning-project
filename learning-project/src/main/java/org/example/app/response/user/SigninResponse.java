package org.example.app.response.user;

import org.example.app.response.ResponseData;

import static org.example.app.constant.ExceptionCode.*;

public class SigninResponse extends ResponseData {
    private String notification;


    public SigninResponse(String notification) {
        super(SUCCESS.getCode(), "Sign in successfully!");
        this.notification = notification;
    }

    public SigninResponse(int code, String message, String notification) {
        super(code, message);
        this.notification = notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }
}
