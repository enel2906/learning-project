package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.*;

public class LoginRequest extends RequestData {
    private String username;
    private String password;

    public LoginRequest(String token , String username, String password){
        super(token);
        this.username = username;
        this.password = password;
    }

    public void checkValidation(){
        if(password.length() < 6 || Util.isNull(username)){
            throw new BusinessException(REQUEST, "Wrong data format");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
