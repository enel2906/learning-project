package org.example.app.api.user;

import org.example.app.constant.ExceptionCode;
import org.example.app.controller.TokenController;
import org.example.app.response.user.LogoutResponse;
import org.example.app.request.user.LogoutRequest;
import org.example.app.util.BusinessException;

import static org.example.app.constant.ExceptionCode.*;

public class LogoutAPI {
    private LogoutAPI(){

    }

    private static LogoutAPI INSTANCE = new LogoutAPI();
    public static LogoutAPI getInstance(){
        return INSTANCE;
    }

    public LogoutResponse execute(LogoutRequest logoutRequest){
        try{
            String token = logoutRequest.getToken();
            if(token == null){
                throw new BusinessException(REQUEST, "Token is null");
            }
            if(!TokenController.getInstance().isValidToken(token)){
                throw new BusinessException(INVALID, "Invalid token");
            }
            TokenController.getInstance().removeToken(token);
            return new LogoutResponse();
        }catch (BusinessException e){
            return new LogoutResponse(e.getCode(), e.getMessage());
        } catch(Exception e){
            return new LogoutResponse(UNKNOWN, e.getMessage());
        }
    }
}
