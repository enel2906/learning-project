package org.example.app.service;

import org.example.app.model.User;
import org.example.app.repository.TokenIdRepository;
import org.example.app.repository.UserRepository;

import java.util.Map;

public class UserService {
    private UserService(){

    }

    private static final UserService INSTANCE = new UserService();

    public static UserService getINSTANCE() {
        return INSTANCE;
    }

    public String addUser(String username, String password, String name, int age, String role){
        User user = new User(username, password, name, age, role);

        return UserRepository.addUser(user);
    }

    public void removeUser(String id){
        UserRepository.removeUser(id);
    }

    public boolean isValidUser(String username, String password){
        User user = UserRepository.findUserByUsernameAndPassword(username, password);
        return user != null;
    }

    public User findAccoount(String username, String password){
        return UserRepository.findUserByUsernameAndPassword(username, password);
    }

    public User findUserById(String id){
        return UserRepository.findUserByID(id);
    }


}
