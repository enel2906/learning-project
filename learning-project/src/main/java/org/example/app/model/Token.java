package org.example.app.model;

import org.example.app.util.Util;

public class Token {
    private String tokenId;

    private String userId;

    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Token(String userId){
        this.userId = userId;
        this.tokenId = createTokenId();
        this.time = 0;
    }

    public Token(String tokenId, String userId){
        this.tokenId = tokenId;
        this.userId = userId;
    }

    public void setTokenId(String tokenId){
        this.tokenId = tokenId;
    }

    public String createTokenId(){
        return Util.getRandomString();
    }

    public String getTokenId() {
        return tokenId;
    }



    public void setTokenId() {
        tokenId = createTokenId();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
