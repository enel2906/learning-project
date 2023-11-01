package org.example.app.api.user;

import org.example.app.constant.ExceptionCode;
import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.response.user.InforResponse;
import org.example.app.request.user.InforRequest;
import org.example.app.util.BusinessException;

import static org.example.app.constant.ExceptionCode.*;

public class GetInforAPI {
    private GetInforAPI(){

    }

    private static GetInforAPI INSTANCE = new GetInforAPI();

    public static GetInforAPI getInstance(){
        return INSTANCE;
    }
    public InforResponse execute(InforRequest request){
        try{
            String token = request.getToken();
            if(token == null){
                throw new BusinessException(REQUEST, "Wrong type of token!");
            }
            if(!TokenController.getInstance().isValidToken(token)){
               throw new BusinessException(INVALID, "Invalid token");
            }
            String id = TokenController.getInstance().getUserId(token);
            if(id == null){
                throw new BusinessException(INVALID, "Invalid Id");
            }
            User user = UserController.getInstance().findUser(id);
            if(user == null){
                throw new BusinessException(INVALID, "Invalid user");
            }
            return new InforResponse(user.getName(), user.getRole(), user.getAge());
        }catch (BusinessException e){
            return new InforResponse(e.getCode(), e.getMessage());
        } catch (Exception e){
            return new InforResponse(UNKNOWN, e.getMessage());
        }
    }
}
