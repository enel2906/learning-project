package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.REQUEST;

public class InforRequest extends RequestData {

    public InforRequest(String token) {
        super(token);
    }
    @Override
    public void checkValidation(){
        if(Util.isNull(token)){
            throw new BusinessException(REQUEST, "Token is null");
        }
    }

}
