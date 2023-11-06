package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.InforResponse;
import org.example.app.response.Response;

public class GetInforAPI extends CommonAPI {
    private GetInforAPI() {

    }

    private static GetInforAPI INSTANCE = new GetInforAPI();

    public static GetInforAPI getInstance() {
        return INSTANCE;
    }

    @Override
    public ResponseData doExecute(RequestData request) throws Exception{
        InforRequest inforRequest = (InforRequest) request;

        String token = inforRequest.getToken();
        String id = TokenController.getInstance().getUserId(token);
        User user = UserController.getInstance().findUser(id);
        return new InforResponse(user.getName(), user.getRole(), user.getAge());
    }
}