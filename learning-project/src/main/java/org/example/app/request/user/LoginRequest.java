package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ApiName.LOGIN_API_NAME;
import static org.example.app.constant.ExceptionCode.*;

public class LoginRequest extends RequestData {
    private String username;
    private String password;


    public LoginRequest( String username, String password){
        super();
        setApiName(LOGIN_API_NAME);
        this.username = username;
        this.password = password;
    }

    public void checkValidation(){
        if(Util.isNull(username) || Util.isNull(password)){
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
