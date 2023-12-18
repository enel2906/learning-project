package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.RequestData;
import org.example.app.request.user.GetUserInforRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.GetUserInforResponse;

import java.util.ArrayList;
import static org.example.app.constant.ExceptionCode.*;

import static org.example.app.constant.Role.*;
public class GetUserInforAPI extends CommonAPI {
    private GetUserInforAPI(){

    }
    private static GetUserInforAPI INSTANCE = new GetUserInforAPI();

    public static GetUserInforAPI getInstance() {
        return INSTANCE;
    }

    @Override
    protected ResponseData doExecute(RequestData requestData) throws Exception {
        GetUserInforRequest getUserInforRequest = (GetUserInforRequest) requestData;
        String token = getUserInforRequest.getToken();
        String userId = getUserInforRequest.getUserId();
        int role = SessionController.getInstance().getRoleByToken(token);
        UserDTO userDTO = UserController.getInstance().getUserDTO(userId);
        if(role != ADMIN.getRole() && userDTO.getRole() == ADMIN.getRole()){
            throw new BusinessException(REQUEST.getCode(), "Normal user can't view information of admin");
        }
        return new GetUserInforResponse(userDTO);
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, GetUserInforRequest.class);
    }
}
