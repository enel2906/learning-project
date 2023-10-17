package org.example.app.controller;

import org.example.app.repository.TokenIdRepository;
import org.example.app.service.TokenService;

public class TokenController {
    private TokenController(){

    }

    private static TokenController INSTANCE = new TokenController();
    public static TokenController getInstance(){
        return INSTANCE;
    }

    public String getUserId(String tokenId){
        return TokenService.getInstance().getUserId(tokenId);
    }

    public String createTokenAndAddToMap(String id){
        return TokenService.getInstance().createToken(id);
    }

    public void removeToken(String token){
        TokenService.getInstance().removeToken(token);
    }

    public boolean isValidToken(String token){
        return TokenService.getInstance().isValidToken(token);
    }

}
