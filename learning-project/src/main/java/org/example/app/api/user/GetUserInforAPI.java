package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.user.GetUserInforRequest;
import org.example.app.response.user.GetUserInforResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.app.constant.ExceptionCode.*;

import static org.example.app.constant.Role.*;

@Component
public class GetUserInforAPI extends CommonAPI<GetUserInforRequest, GetUserInforResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public GetUserInforAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    @Override
    public GetUserInforResponse doExecute(GetUserInforRequest getUserInforRequest) throws Exception {
        String token = getUserInforRequest.getToken();
        String userId = getUserInforRequest.getUserId();
        int role = sessionService.getRoleByToken(token);
        UserDTO userDTO = userService.findDTOByKey(userId);
        if(role != ADMIN.getRole() && userDTO.getRole() == ADMIN.getRole()){
            throw new BusinessException(REQUEST.getCode(), "Normal user can't view information of admin");
        }
        return new GetUserInforResponse(userDTO);
    }
}
