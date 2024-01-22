package org.example.app.response.user;

import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.example.app.constant.ExceptionCode.*;
@ResponseBody
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

    public SigninResponse(int code, String message){
        super(code, message);
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }
}
