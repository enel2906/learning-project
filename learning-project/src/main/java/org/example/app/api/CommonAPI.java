package org.example.app.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.constant.ApiName;
import org.example.app.controller.SessionController;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.response.Response;
import org.example.app.response.ResponseData;

import static org.example.app.constant.ApiName.UNAUTHEN_API;
import static org.example.app.constant.ExceptionCode.*;

public class CommonAPI {
        public Response execute(JsonObject jsonObject){
        try {
            RequestData requestData = parseRequestData(jsonObject);
            requestData.checkValidation();
            String apiNameString = requestData.getApiName();
            ApiName apiName = ApiName.fromString(apiNameString);
            if(!UNAUTHEN_API.contains(apiName)){
                String token = requestData.getToken();
                boolean check = SessionController.getInstance().isValidToken(token);
                if(!check){
                    throw new BusinessException(INVALID.getCode(), "token doesn't exist in system");
                }
                SessionController.getInstance().updateCurrentActivity(token);
            }
            ResponseData responseData = doExecute(requestData);
            return new Response(SUCCESS.getCode(), "success message", responseData);
        }catch (BusinessException e){
            return new Response(e.getCode(), e.getMessage(), null);
        } catch(Exception e){
            return new Response(UNKNOWN.getCode(), e.getMessage(), null);
        }

    }
    protected ResponseData doExecute(RequestData requestData) throws Exception{
        return new ResponseData();
    }

    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, RequestData.class);
    }
}
