package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.user.GetUserInforRequest;
import org.example.app.response.user.GetUserInforResponse;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;

import static org.example.app.constant.ExceptionCode.*;

import static org.example.app.constant.Role.*;
public class GetUserInforAPI extends CommonAPI<GetUserInforRequest, GetUserInforResponse> {
    private GetUserInforAPI(){

    }
    private static GetUserInforAPI INSTANCE = new GetUserInforAPI();

    public static GetUserInforAPI getInstance() {
        return INSTANCE;
    }

    @Override
    public GetUserInforResponse doExecute(GetUserInforRequest getUserInforRequest) throws Exception {
        String token = getUserInforRequest.getToken();
        String userId = getUserInforRequest.getUserId();
        int role = SessionService.getINSTANCE().getRoleByToken(token);
        UserDTO userDTO = UserService.getINSTANCE().findDTOByKey(userId);
        if(role != ADMIN.getRole() && userDTO.getRole() == ADMIN.getRole()){
            throw new BusinessException(REQUEST.getCode(), "Normal user can't view information of admin");
        }
        return new GetUserInforResponse(userDTO);
    }
}
