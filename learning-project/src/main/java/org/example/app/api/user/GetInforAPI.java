package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.request.user.InforRequest;
import org.example.app.response.user.InforResponse;

public class GetInforAPI extends CommonAPI<InforRequest, InforResponse> {
    private GetInforAPI() {

    }
    private static GetInforAPI INSTANCE = new GetInforAPI();

    public static GetInforAPI getInstance() {
        return INSTANCE;
    }

    @Override
    public InforResponse doExecute(InforRequest inforRequest) throws Exception{
        String token = inforRequest.getToken();
        String id = SessionController.getInstance().getUserId(token);
        User user = UserController.getInstance().findUser(id);
        return new InforResponse(user.getName(), user.getRole(), user.getAge());
    }

    @Override
    public InforRequest parseRequestData(JsonObject jsonObject) throws Exception{
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, InforRequest.class);
    }
}