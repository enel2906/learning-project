package org.example.app.service;

import org.example.app.model.User;
import org.example.app.model.dto.UserDTO;
import org.example.app.repository.UserRepository;

import java.util.ArrayList;

public class UserService {
    private UserService(){

    }

    private static final UserService INSTANCE = new UserService();

    public static UserService getINSTANCE() {
        return INSTANCE;
    }

    public String addUser(String username, String password, String name, int age, int role, String address) throws Exception{
        return UserRepository.addUser(username, password, name, age, role, address);
    }

    public void removeUser(String id){
        UserRepository.removeUser(id);
    }

    public boolean isValidUser(String username, String password) throws Exception{
        User user = UserRepository.findUserByUsernameAndPassword(username, password);
        return user != null;
    }

    public User findAccoount(String username, String password) throws Exception{
        return UserRepository.findUserByUsernameAndPassword(username, password);
    }

    public User findUserById(String id) throws Exception{
        return UserRepository.findUserByID(id);
    }
    public void changeAgeOfUser(String id, int ageChange) throws Exception{
        UserRepository.changeAgeOfUser(id, ageChange);
    }
    public int getRole(String id) throws Exception {
        return UserRepository.getRole(id);
    }

    public String getName(String id) throws Exception{
        return UserRepository.getName(id);
    }
    public UserDTO getUserDTO(String userId) throws Exception {
        return UserRepository.getUserDTO(userId);
    }
    public ArrayList<UserDTO> getNormalUser(String name) throws Exception {
        return UserRepository.getNormalUser(name);
    }
    public ArrayList<UserDTO> getUserAndAdminByName(String name) throws Exception {
        return UserRepository.getUserAndAdminByName(name);
    }
}
