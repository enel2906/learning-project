package org.example.app.controller.user;

import org.example.app.api.user.GetInforAPI;
import org.example.app.api.user.LoginAPI;
import org.example.app.request.user.InforRequest;
import org.example.app.request.user.LoginRequest;
import org.example.app.response.user.InforResponse;
import org.example.app.response.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final LoginAPI loginAPI;
    private final GetInforAPI getInforAPI;

    public UserController(LoginAPI loginAPI, GetInforAPI getInforAPI){
        this.loginAPI = loginAPI;
        this.getInforAPI = getInforAPI;
    }

    @GetMapping("/information/{token}")
    public InforResponse getInforResponse(@PathVariable String token){
        InforRequest inforRequest = new InforRequest(token);
        return (InforResponse) getInforAPI.execute(inforRequest);
    }

    @PostMapping("/login")
    public LoginResponse doLogin(@RequestBody LoginRequest loginRequest){
        return (LoginResponse) loginAPI.execute(loginRequest);
    }


}
