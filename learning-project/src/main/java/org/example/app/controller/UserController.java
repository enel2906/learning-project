package org.example.app.controller;

import org.example.app.model.User;
import org.example.app.service.UserService;

import java.util.Map;

public class UserController {
    private UserController(){

    }

    private static UserController INSTANCE = new UserController();
    public static UserController getInstance(){
        return INSTANCE;
    }

    public String addUser(String username, String password, String name, int age, String role){
        return UserService.getINSTANCE().addUser(username, password, name, age, role);
    }

    public void removeUser(String token){
        UserService.getINSTANCE().removeUser(token);
    }

    public User findUser(String id){
        return UserService.getINSTANCE().findUserById(id);
    }

    public String accessAccount(String username, String password){
        User user = UserService.getINSTANCE().findAccoount(username,password);
        if(user == null){
            return null;
        }
        return user.getId();
    }

    public boolean isValidUserNameAndPassword(String username, String password){
        return UserService.getINSTANCE().isValidUser(username, password);
    }


}
