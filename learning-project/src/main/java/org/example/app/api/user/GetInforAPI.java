package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.model.User;
import org.example.app.request.user.InforRequest;
import org.example.app.response.user.InforResponse;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;

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
        String id = SessionService.getINSTANCE().getUserId(token);
        User user = UserService.getINSTANCE().findByKey(id);
        return new InforResponse(user.getName(), user.getRole(), user.getAge());
    }
}