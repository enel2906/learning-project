package org.example.app.controller;

import org.example.app.model.User;
import org.example.app.service.UserService;

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


    public String createToken(String id){
        return UserService.getINSTANCE().createToken(id);
    }

    public void removeUser(String token){
        UserService.getINSTANCE().removeUser(token);
    }

    public User findUserByToken(String token){
        return UserService.getINSTANCE().findUserByToken(token);
    }

    public String accessAccount(String username, String password){
        if(!UserService.getINSTANCE().isValidUser(username, password)){
            System.out.println("Invalid account!!!");
            return null;
        }
        User user = UserService.getINSTANCE().findAccoount(username,password);
        String token = UserService.getINSTANCE().createToken(user.getId());
        return token;
    }

    public void logoutUser(String token){
        UserService.getINSTANCE().removeToken(token);
    }
}
