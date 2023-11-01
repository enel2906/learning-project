package org.example.app.controller;

import org.example.app.model.User;
import org.example.app.service.UserService;
import org.example.app.exception.BusinessException;
import org.example.app.util.Util;


import static org.example.app.constant.ExceptionCode.*;

public class UserController {
    private UserController(){

    }

    private static UserController INSTANCE = new UserController();
    public static UserController getInstance(){
        return INSTANCE;
    }

    public String addUser(String username, String password, String name, int age, String role){
        try {
            return UserService.getINSTANCE().addUser(username, password, name, age, role);
        } catch (Exception e) {
            throw new BusinessException(UNKNOWN, e.getMessage());
        }
    }

    public void removeUser(String token){
        UserService.getINSTANCE().removeUser(token);
    }

    public User findUser(String id){
        try{
            User user = UserService.getINSTANCE().findUserById(id);
            if(Util.isNull(user)){
                throw new Exception("Invalid user!");
            }
            return user;
        }catch (Exception e){
            throw new BusinessException(UNKNOWN, e.getMessage());
        }
    }

    public String accessAccount(String username, String password){
        try{
            User user = UserService.getINSTANCE().findAccoount(username,password);
            String id = user.getId();
            if(Util.isNull(id)){
                throw new Exception("Id is null");
            }
            return id;
        }catch(Exception e){
            throw new BusinessException(UNKNOWN, e.getMessage());
        }
    }

    public boolean isValidUserNameAndPassword(String username, String password){
        try{
            return UserService.getINSTANCE().isValidUser(username, password);
        }catch(Exception e){
            throw new BusinessException(UNKNOWN, e.getMessage());
        }
    }


}
