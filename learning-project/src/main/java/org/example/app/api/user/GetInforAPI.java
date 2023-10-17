package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.reponse.user.InforReponse;
import org.example.app.request.user.InforRequest;

public class GetInforAPI {
    private GetInforAPI(){

    }

    private static GetInforAPI INSTANCE = new GetInforAPI();

    public static GetInforAPI getInstance(){
        return INSTANCE;
    }
    public InforReponse execute(InforRequest request){
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
        return new InforReponse(user.getName(), user.getRole(), user.getAge());
    }
}
