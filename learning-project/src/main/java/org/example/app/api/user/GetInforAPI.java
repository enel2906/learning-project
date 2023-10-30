package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.response.user.InforResponse;
import org.example.app.request.user.InforRequest;

public class GetInforAPI {
    private GetInforAPI(){

    }

    private static GetInforAPI INSTANCE = new GetInforAPI();

    public static GetInforAPI getInstance(){
        return INSTANCE;
    }
    public InforResponse execute(InforRequest request){
        String token = request.getToken();
        if(!TokenController.getInstance().isValidToken(token)){
            System.out.println("token is null");
            return null;
        }
        String id = TokenController.getInstance().getUserId(token);
        if(id == null){
            System.out.println("id is null");
            return null;
        }
        User user = UserController.getInstance().findUser(id);
        if(user == null){
            return null;
        }
        return new InforResponse(user.getName(), user.getRole(), user.getAge());
    }
}
