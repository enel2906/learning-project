package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.response.user.LogoutResponse;
import org.example.app.request.user.LogoutRequest;
import org.example.app.service.SessionService;

public class LogoutAPI extends CommonAPI<LogoutRequest, LogoutResponse> {
    private LogoutAPI(){

    }
    private static LogoutAPI INSTANCE = new LogoutAPI();
    public static LogoutAPI getInstance(){
        return INSTANCE;
    }

    public LogoutResponse doExecute(LogoutRequest request) throws Exception{
        String token = request.getToken();
        System.out.println(token);
        SessionService.getINSTANCE().remove(token);

        return new LogoutResponse();
    }
}
