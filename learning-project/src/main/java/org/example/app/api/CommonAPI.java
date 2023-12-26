package org.example.app.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.constant.ApiName;
import org.example.app.controller.SessionController;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.response.ResponseData;

import java.util.List;

import static org.example.app.constant.ApiName.UNAUTHEN_API;
import static org.example.app.constant.ExceptionCode.*;

public abstract class CommonAPI<T extends RequestData, V extends ResponseData> implements InterfaceAPI<T, V> {
        public V execute(JsonObject jsonObject){
        try {
            T requestData = (T) parseRequestData(jsonObject);
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
            return doExecute(requestData);
        }catch (BusinessException e){
            return (V) new ResponseData(e.getCode(), e.getMessage());
        } catch(Exception e){
            return (V) new ResponseData(UNKNOWN.getCode(), e.getMessage());
        }
    }
    public abstract V doExecute(T r) throws Exception;

    public abstract T parseRequestData(JsonObject jsonObject) throws Exception;

}
