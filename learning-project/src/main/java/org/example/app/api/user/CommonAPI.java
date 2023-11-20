package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.constant.ApiName;
import org.example.app.constant.ExceptionCode;
import org.example.app.controller.TokenController;
import org.example.app.exception.BusinessException;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.response.Response;
import org.example.app.response.ResponseData;
import org.example.app.util.Util;

import static org.example.app.constant.ApiName.UNAUTHEN_API;
import static org.example.app.constant.ExceptionCode.*;

public class CommonAPI {
        public Response execute(JsonObject jsonObject){
        try {
            RequestData requestData = parseRequestData(jsonObject);
            requestData.checkValidation();
            String apiName = requestData.getApiName();
            if(!UNAUTHEN_API.contains(apiName)){
                String token = requestData.getToken();
                boolean check = TokenController.getInstance().isValidToken(token);
                if(!check){
                    throw new BusinessException(INVALID, "token doesn't exist in system");
                }
            }
            ResponseData responseData = doExecute(requestData);
            return new Response(SUCCESS, "success message", responseData);
        }catch (BusinessException e){
            return new Response(e.getCode(), e.getMessage(), null);
        } catch(Exception e){
            return new Response(UNKNOWN, "ERROR" , null);
        }

    }
    protected ResponseData doExecute(RequestData requestData) throws Exception{
        return new ResponseData();
    }

    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        RequestData requestData = gson.fromJson(jsonObject, RequestData.class);
        return requestData;
    }
}
