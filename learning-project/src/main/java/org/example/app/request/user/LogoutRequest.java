package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ApiName.LOGOUT_API_NAME;
import static org.example.app.constant.ExceptionCode.INVALID;

public class LogoutRequest extends RequestData {
    public LogoutRequest(String token){
        super(token);
    }

}
