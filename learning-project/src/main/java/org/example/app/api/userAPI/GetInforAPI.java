package org.example.app.api.userAPI;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.reponse.userreponse.InforReponse;
import org.example.app.request.userrequest.InforRequest;

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
            //TOD print
            return null;
        }
        String id = TokenController.getInstance().getUserId(token);
        //TODO check id
        User user = UserController.getInstance().findUser(id);
        //TODO check user
        return new InforReponse(user.getName(), user.getRole(), user.getAge());
    }
}
