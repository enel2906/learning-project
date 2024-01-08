package org.example.app.service;

import org.example.app.model.User;
import org.example.app.model.dto.UserDTO;
import org.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.ArrayList;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User findByKey(String id) throws Exception {
        return userRepository.findUserByID(id);
    }
    public void remove(String id) throws Exception{
        userRepository.removeUser(id);
    }

    public boolean isValid(String id) throws Exception {
        return false;
    }
    public UserDTO findDTOByKey(String id) throws Exception {
        return userRepository.getUserDTO(id);
    }

    public String addUser(String username, String password, String name, int age, int role, String address) throws Exception{
        return userRepository.addUser(username, password, name, age, role, address);
    }


    public boolean isValidUser(String username, String password) throws Exception{
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        return user != null;
    }

    public User findAccoount(String username, String password) throws Exception{
        return userRepository.findUserByUsernameAndPassword(username, password);
    }
    public void changeAgeOfUser(String id, int ageChange) throws Exception{
        userRepository.changeAgeOfUser(id, ageChange);
    }
    public int getRole(String id) throws Exception {
        return userRepository.getRole(id);
    }

    public String getName(String id) throws Exception{
        return userRepository.getName(id);
    }
    public ArrayList<UserDTO> getNormalUser(String name) throws Exception {
        return userRepository.getNormalUser(name);
    }
    public ArrayList<UserDTO> getUserAndAdminByName(String name) throws Exception {
        return userRepository.getUserAndAdminByName(name);
    }

    public List<UserDTO> getListUserFromId(List<String> userIds) throws Exception {
        return userRepository.getListUsers(userIds);
    }
}
