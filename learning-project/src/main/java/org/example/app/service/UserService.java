package org.example.app.service;

import org.example.app.model.User;
import org.example.app.model.dto.UserDTO;
import org.example.app.repository.UserRepository;

import java.util.List;

import java.util.ArrayList;

public class UserService implements ServiceInterfaceDTO<UserDTO, User> {
    private UserService(){

    }

    public static UserService getINSTANCE() {
        return INSTANCE;
    }
    private static final UserService INSTANCE = new UserService();
    public User findByKey(String id) throws Exception {
        return UserRepository.findUserByID(id);
    }
    public void remove(String id) throws Exception{
        UserRepository.removeUser(id);
    }

    public boolean isValid(String id) throws Exception {
        return false;
    }
    public UserDTO findDTOByKey(String id) throws Exception {
        return UserRepository.getUserDTO(id);
    }

    public String addUser(String username, String password, String name, int age, int role, String address) throws Exception{
        return UserRepository.addUser(username, password, name, age, role, address);
    }


    public boolean isValidUser(String username, String password) throws Exception{
        User user = UserRepository.findUserByUsernameAndPassword(username, password);
        return user != null;
    }

    public User findAccoount(String username, String password) throws Exception{
        return UserRepository.findUserByUsernameAndPassword(username, password);
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
    public ArrayList<UserDTO> getNormalUser(String name) throws Exception {
        return UserRepository.getNormalUser(name);
    }
    public ArrayList<UserDTO> getUserAndAdminByName(String name) throws Exception {
        return UserRepository.getUserAndAdminByName(name);
    }

    public List<UserDTO> getListUserFromId(List<String> userIds) throws Exception {
        return UserRepository.getListUsers(userIds);
    }
}
