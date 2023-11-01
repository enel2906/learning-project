package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.INVALID;

public class LogoutRequest {
    private String token;
    public LogoutRequest(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void checkValidation(){
        if(Util.isNull(token)){
            throw new BusinessException(INVALID, "Invalid token");
        }
    }
}
