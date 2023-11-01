package org.example.app.controller;

import org.example.app.repository.TokenIdRepository;
import org.example.app.service.TokenService;
import org.example.app.util.BusinessException;

import java.util.Map;

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

    public String createTokenAndAddToMap(String id) {

        return TokenService.getInstance().createToken(id);
    }

    public void removeToken(String token){
        TokenService.getInstance().removeToken(token);
    }

    public boolean isValidToken(String token){
        return TokenService.getInstance().isValidToken(token);
    }

    public int getTimeOfToken(String tokenId){
        return TokenService.getInstance().getTimeOfToken(tokenId);
    }

    public Map<String, Map<String, Object>> getTokenIdMap(){
        return TokenService.getInstance().getTokenIdMap();
    }

    public  String getTokenId() {
        return TokenService.getInstance().getTokenId();
    }

    public String getUserId() {
        return TokenService.getInstance().getUserId();
    }

    public String getTIME() {
        return TokenService.getInstance().getTIME();
    }
}
