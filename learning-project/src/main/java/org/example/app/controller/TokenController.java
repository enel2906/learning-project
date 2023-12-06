package org.example.app.controller;

import org.example.app.service.TokenService;
import org.example.app.exception.BusinessException;

import java.util.Map;

import static org.example.app.constant.ExceptionCode.INVALID;
import static org.example.app.constant.ExceptionCode.UNKNOWN;

public class TokenController {
    private TokenController(){

    }

    private static TokenController INSTANCE = new TokenController();
    public static TokenController getInstance(){
        return INSTANCE;
    }

    public String getUserId(String tokenId){
        if(!isValidToken(tokenId)){
            throw new BusinessException(INVALID, "Token is invalid");
        }
        return TokenService.getInstance().getUserId(tokenId);
    }

    public String createTokenAndAddToMap(String id) {
        return TokenService.getInstance().createToken(id);
    }

    public void removeToken(String token){
        try{
            TokenService.getInstance().removeToken(token);
        }catch(Exception e){
            throw new BusinessException(UNKNOWN, e.getMessage());
        }
    }

    public boolean isValidToken(String token){
        try{
            return TokenService.getInstance().isValidToken(token);
        }catch(Exception e){
            throw new BusinessException(UNKNOWN, e.getMessage());
        }
    }

    public long getTimeOfToken(String tokenId){
        return TokenService.getInstance().getTimeOfToken(tokenId);
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
