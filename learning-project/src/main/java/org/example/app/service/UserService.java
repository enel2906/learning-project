package org.example.app.service;

import org.example.app.model.User;
import org.example.app.repository.TokenIdRepository;
import org.example.app.repository.UserRepository;

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

    public void removeUser(String token){
        String id = TokenIdRepository.getId(token);
        removeId(token);
        UserRepository.removeUser(id);
    }

    public String getId(String token){
        return TokenIdRepository.getId(token);
    }

    public void removeId(String token){
        TokenIdRepository.removeToken(token);
    }

    public String createToken(String id){
        return TokenIdRepository.addTokenId(id);
    }

    public boolean idValidUserName(String username){
        User user = UserRepository.findUserByUserName(username);
        if(user != null){
            return true;
        }
        return false;
    }

    public boolean isValidPassWord(String password){
        User user = UserRepository.findUserByPassWord(password);
        if(user != null){
            return true;
        }
        return false;
    }



}
