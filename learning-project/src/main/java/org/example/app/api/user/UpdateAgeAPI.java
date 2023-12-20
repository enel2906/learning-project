package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.request.RequestData;
import org.example.app.request.user.UpdateAgeRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.UpdateAgeResponse;

public class UpdateAgeAPI extends CommonAPI {

    private UpdateAgeAPI(){

    }

    private static final UpdateAgeAPI INSTANCE = new UpdateAgeAPI();

    public static UpdateAgeAPI getINSTANCE() {
        return INSTANCE;
    }

    protected ResponseData doExecute(RequestData requestData) throws Exception{
        UpdateAgeRequest request = (UpdateAgeRequest) requestData;
        String token = request.getToken();
        int ageChange = request.getAgeChange();

        String id = SessionController.getInstance().getUserId(token);
        UserController.getInstance().changeAgeOfUser(id, ageChange);
        User user = UserController.getInstance().findUser(id);
        if(ageChange >= 0){
            return new UpdateAgeResponse("Already add "+ageChange+" to user: "+user.getName()+"!");
        }
        return new UpdateAgeResponse("Already minute "+(-1)*ageChange+" to user: "+user.getName()+"!");
    }

    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, UpdateAgeRequest.class);
    }
}
