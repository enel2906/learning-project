package org.example.app.service;

import org.example.app.repository.TokenIdRepository;

public class TokenService {
    private TokenService(){

    }

    private static TokenService INSTANCE = new TokenService();

    public static TokenService getInstance(){
        return INSTANCE;
    }

    public String getUserId(String token){
        return TokenIdRepository.getUserId(token);
    }

    public boolean isValidToken(String token){
        return TokenIdRepository.isValidToken(token);
    }

    public void removeToken(String token){
        if(!isValidToken(token)){
            return;
        }
       TokenIdRepository.removeToken(token);
    }

    public String createToken(String id){
        return TokenIdRepository.createToken(id);
    }
}
