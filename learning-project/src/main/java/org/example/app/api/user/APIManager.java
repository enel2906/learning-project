package org.example.app.api.user;

import com.google.gson.JsonObject;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.request.user.LogoutRequest;
import org.example.app.request.user.UpdateAgeRequest;
import org.example.app.response.Response;

import static org.example.app.constant.ApiName.*;
import static org.example.app.constant.ApiName.AGE_CHANGE;

public class APIManager {
    public static CommonAPI getAPI(String apiName){
        switch (apiName) {
            case GETINFOR_API_NAME:
                return GetInforAPI.getInstance();
            case LOGOUT_API_NAME:
                return LogoutAPI.getInstance();
            case UPDATE_AGE_NAME:
                return UpdateAgeAPI.getINSTANCE();
            default:
                return null;
        }
    }
}
