package org.example.app.request;


import com.google.gson.JsonObject;
import org.example.app.exception.BusinessException;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.INVALID;
import static org.example.app.constant.ExceptionCode.REQUEST;

public class RequestData {
    private String apiName;

    public RequestData(){

    }
    public RequestData(String token) {
        this.token = token;
    }

    protected String token;
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


    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

}
