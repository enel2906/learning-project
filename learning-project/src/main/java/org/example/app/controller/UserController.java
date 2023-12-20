package org.example.app.controller;

import org.example.app.model.User;
import org.example.app.model.dto.UserDTO;
import org.example.app.repository.UserRepository;
import org.example.app.service.UserService;
import org.example.app.exception.BusinessException;
import org.example.app.util.Util;


import java.util.ArrayList;
import java.util.List;

import static org.example.app.constant.ExceptionCode.*;

public class UserController {
    private UserController(){

    }

    private static UserController INSTANCE = new UserController();
    public static UserController getInstance(){
        return INSTANCE;
    }

    public String addUser(String username, String password, String name, int age, int role, String address, List<String> ipLogin) throws Exception {
            return UserService.getINSTANCE().addUser(username, password, name, age, role, address);
    }

    public void removeUser(String token) throws Exception {
        UserService.getINSTANCE().remove(token);
    }

    public User findUser(String id) throws Exception{
        return UserService.getINSTANCE().findByKey(id);
    }

    public String accessAccount(String username, String password) throws Exception {
            User user = UserService.getINSTANCE().findAccoount(username,password);
            return user.getId();
    }

    public boolean isValidUserNameAndPassword(String username, String password) throws Exception {
            return UserService.getINSTANCE().isValidUser(username, password);
    }

    public void changeAgeOfUser(String id, int ageChange) throws Exception{
        UserService.getINSTANCE().changeAgeOfUser(id, ageChange);
    }

    public int getRole(String id) throws Exception {
        return UserService.getINSTANCE().getRole(id);
    }

    public String getName(String id) throws Exception{
        return UserService.getINSTANCE().getName(id);
    }
    public UserDTO getUserDTO(String userId) throws Exception{
        return UserService.getINSTANCE().findDTOByKey(userId);
    }
    public ArrayList<UserDTO> getNormalUser(String name) throws Exception {
        return UserService.getINSTANCE().getNormalUser(name);
    }
    public ArrayList<UserDTO> getUserAndAdminByName(String name) throws Exception{
        return UserService.getINSTANCE().getUserAndAdminByName(name);
    }
    public List<UserDTO> getListUserFromId(List<String> userIds) throws Exception {
        return UserService.getINSTANCE().getListUserFromId(userIds);
    }
}
