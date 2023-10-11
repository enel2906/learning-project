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

    public String createToken(String id){
        return UserService.getINSTANCE().createToken(id);
    }

    public void removeUser(String token){
        UserService.getINSTANCE().removeUser(token);
    }

    public void addValidUSer(String username, String password){
        boolean validUsername = UserService.getINSTANCE().idValidUserName(username);
        boolean validPassWord = UserService.getINSTANCE().isValidPassWord(password);
        if(validUsername==false || validPassWord == false){
            if(validUsername == false){
                System.out.println("Your username is invalid!!!");
            }
            else if(validPassWord == false){
                System.out.println("Your password is invalid!!!");
            }
            else{
                System.out.println("Your username and password are invalid!!!");
            }
            return;
        }

        String token

    }
}
