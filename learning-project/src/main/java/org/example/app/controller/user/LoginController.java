//package org.example.app.controller.user;
//
//import org.example.app.api.user.LoginAPI;
//import org.example.app.request.user.LoginRequest;
//import org.example.app.response.user.LoginResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class LoginController {
//    private final LoginAPI loginAPI;
//    @Autowired
//    public LoginController(LoginAPI loginAPI){
//        this.loginAPI = loginAPI;
//    }
//
//    @PostMapping
//    public LoginResponse doLogin(@RequestBody LoginRequest loginRequest){
//        return (LoginResponse) loginAPI.execute(loginRequest);
//    }
//}
