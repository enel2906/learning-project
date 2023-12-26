package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.*;

public class LoginRequest extends RequestData {
    private String username;
    private String password;
    private String ipLogin;

    public String getIpLogin() {
        return ipLogin;
    }

    public void setIpLogin(String ipLogin) {
        this.ipLogin = ipLogin;
    }

    public LoginRequest(String apiName, String username, String password, String ipLogin){
        super();
        setApiName(apiName);
        this.username = username;
        this.password = password;
        this.ipLogin = ipLogin;
    }

    public void checkValidation(){
        if(Util.isNull(username) || Util.isNull(password) || Util.isNull(ipLogin)){
            throw new BusinessException(REQUEST.getCode(), "Wrong data format");
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
