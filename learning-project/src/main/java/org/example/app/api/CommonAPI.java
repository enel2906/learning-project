package org.example.app.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.constant.ApiName;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.response.ResponseData;
import org.example.app.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.app.constant.ApiName.UNAUTHEN_API;
import static org.example.app.constant.ExceptionCode.*;


public abstract class CommonAPI<T extends RequestData, V extends ResponseData> implements InterfaceAPI<T> {
    private final SessionService sessionService;

    public CommonAPI(SessionService sessionService){
        this.sessionService = sessionService;
    }

    public ResponseData execute(T requestData){
        try {
            requestData.checkValidation();
            String apiNameString = requestData.getApiName();
            ApiName apiName = ApiName.fromString(apiNameString);
            if(!UNAUTHEN_API.contains(apiName)){
                String token = requestData.getToken();
                boolean check = sessionService.isValid(token);
                if(!check){
                    throw new BusinessException(INVALID.getCode(), "token doesn't exist in system");
                }
                sessionService.updateRecentActivity(token);
            }
            return doExecute(requestData);
        }catch (BusinessException e){
            return new ResponseData(e.getCode(), e.getMessage());
        } catch(Exception e){
            return new ResponseData(UNKNOWN.getCode(), e.getMessage());
        }
    }
    public abstract V doExecute(T r) throws Exception;


}
