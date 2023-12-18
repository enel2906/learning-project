package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.INVALID;
import static org.example.app.constant.ExceptionCode.REQUEST;
import static org.example.app.constant.ApiName.GETINFOR_API_NAME;

public class InforRequest extends RequestData {

    public InforRequest(String token) {
        super(token);
    }

}
