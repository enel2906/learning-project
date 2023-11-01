package org.example.app.api.user;

import org.example.app.constant.ExceptionCode;
import org.example.app.exception.BusinessException;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.response.Response;
import org.example.app.response.ResponseData;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.REQUEST;
import static org.example.app.constant.ExceptionCode.UNKNOWN;

public class CommonAPI {

    public Response execute(Request request){
        try {
            RequestData requestData = request.getRequestData();
            String token = requestData.getToken();
            if(Util.isNull(token)){
                throw new BusinessException(REQUEST, "Token is null");
            }
            requestData.checkValidation();
            ResponseData responseData = doExecute(requestData);
            return new Response(ExceptionCode.SUCCESS,"success message", responseData);
        }catch (BusinessException e){
            return new Response(e.getCode(), e.getMessage(), null);
        } catch(Exception e){
            return new Response(UNKNOWN, "ERROR" , null);
        }

    }
    protected ResponseData doExecute(RequestData requestData) throws Exception{
        return new ResponseData();
    }


}
