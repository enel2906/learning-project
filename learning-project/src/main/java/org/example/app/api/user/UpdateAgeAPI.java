package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.model.User;
import org.example.app.request.user.UpdateAgeRequest;
import org.example.app.response.user.UpdateAgeResponse;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;

public class UpdateAgeAPI extends CommonAPI<UpdateAgeRequest, UpdateAgeResponse> {

    private UpdateAgeAPI(){

    }

    private static final UpdateAgeAPI INSTANCE = new UpdateAgeAPI();

    public static UpdateAgeAPI getINSTANCE() {
        return INSTANCE;
    }

    public UpdateAgeResponse doExecute(UpdateAgeRequest request ) throws Exception{
        String token = request.getToken();
        int ageChange = request.getAgeChange();

        String id = SessionService.getINSTANCE().getUserId(token);
        UserService.getINSTANCE().changeAgeOfUser(id, ageChange);
        User user = UserService.getINSTANCE().findByKey(id);
        if(ageChange >= 0){
            return new UpdateAgeResponse("Already add "+ageChange+" to user: "+user.getName()+"!");
        }
        return new UpdateAgeResponse("Already minute "+(-1)*ageChange+" to user: "+user.getName()+"!");
    }
}
