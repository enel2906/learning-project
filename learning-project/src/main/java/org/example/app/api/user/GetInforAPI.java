package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.InforResponse;

public class GetInforAPI extends CommonAPI {
    private GetInforAPI() {

    }
    private static GetInforAPI INSTANCE = new GetInforAPI();

    public static GetInforAPI getInstance() {
        return INSTANCE;
    }

    @Override
    public ResponseData doExecute(RequestData requestData) throws Exception{
        InforRequest inforRequest = (InforRequest) requestData;

        String token = inforRequest.getToken();
        String id = SessionController.getInstance().getUserId(token);
        User user = UserController.getInstance().findUser(id);
        return new InforResponse(user.getName(), user.getRole(), user.getAge());
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, InforRequest.class);
    }
}