package org.example.app.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import org.example.app.api.post.AddNewPostAPI;
import org.example.app.api.post.GetPostOfUserAPI;
import org.example.app.api.user.*;
import org.example.app.request.post.AddNewPostRequest;
import org.example.app.request.post.GetPostRequest;
import org.example.app.request.user.*;
import org.example.app.response.post.AddNewPostResponse;
import org.example.app.response.post.GetPostResponse;
import org.example.app.response.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private static final String TOKEN_KEY = "Token";
    private static final String AGE_PARAM_KEY = "age-update";
    private final LoginAPI loginAPI;
    private final GetInforAPI getInforAPI;
    private final GetUserInforAPI getUserInforAPI;
    private final LogoutAPI logoutAPI;
    private final UpdateAgeAPI updateAgeAPI;
    private final GetPostOfUserAPI getPostOfUserAPI;
    private final AddNewPostAPI addNewPostAPI;

    public UserController(LoginAPI loginAPI,
                          GetInforAPI getInforAPI,
                          GetUserInforAPI getUserInforAPI,
                          LogoutAPI logoutAPI,
                          UpdateAgeAPI updateAgeAPI,
                          GetPostOfUserAPI getPostOfUserAPI,
                          AddNewPostAPI addNewPostAPI){
        this.loginAPI = loginAPI;
        this.getInforAPI = getInforAPI;
        this.getUserInforAPI = getUserInforAPI;
        this.logoutAPI = logoutAPI;
        this.updateAgeAPI = updateAgeAPI;
        this.getPostOfUserAPI = getPostOfUserAPI;
        this.addNewPostAPI = addNewPostAPI;
    }
    @PostMapping
    public LoginResponse doLogin(@RequestBody LoginRequest loginRequest){
        return loginAPI.execute(loginRequest);
    }

    @GetMapping("/information")
    public InforResponse getInforResponse(HttpServletRequest request){
        String token = request.getHeader(TOKEN_KEY);
        InforRequest inforRequest = new InforRequest(token);
        return getInforAPI.execute(inforRequest);
    }

    @GetMapping("/get-user-information/{userId}")
    public GetUserInforResponse getOtherUserInformation(HttpServletRequest request, @PathVariable String userId){
        String token = request.getHeader(TOKEN_KEY);
        GetUserInforRequest getUserInforRequest = new GetUserInforRequest(token, userId);
        return getUserInforAPI.execute(getUserInforRequest);
    }
    @DeleteMapping("/logout")
    public LogoutResponse logout(HttpServletRequest request){
        String token = request.getHeader(TOKEN_KEY);
        LogoutRequest logoutRequest = new LogoutRequest(token);
        return logoutAPI.execute(logoutRequest);
    }
    @PostMapping("/update-age")
    public UpdateAgeResponse updateAge(HttpServletRequest request){
        String token = request.getHeader(TOKEN_KEY);
        int ageUpdate = Integer.parseInt(request.getParameter(AGE_PARAM_KEY));

        UpdateAgeRequest updateAgeRequest = new UpdateAgeRequest(token, ageUpdate);
        return updateAgeAPI.execute(updateAgeRequest);
    }
    @GetMapping("/getPostOfUser/{userId}")
    public GetPostResponse getPostOfUser(@PathVariable String userId,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int limit){

        GetPostRequest getPostRequest = new GetPostRequest(userId, page, limit);
        return getPostOfUserAPI.execute(getPostRequest);
    }

    @PostMapping("/add-post")
    public AddNewPostResponse addPost(HttpServletRequest request, @RequestBody AddNewPostRequest addNewPostRequest){
        String token = request.getHeader(TOKEN_KEY);
        addNewPostRequest.setToken(token);
        return addNewPostAPI.execute(addNewPostRequest);
    }

}


