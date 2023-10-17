package org.example.app.model;

import org.example.app.util.Util;

public class Token {
    private String tokenId;

    private String userId;

    public Token(String userId){
        this.userId = userId;
        this.tokenId = createTokenId();

    }

    public Token(String tokenId, String userId){
        this.tokenId = tokenId;
        this.userId = userId;
    }

    public void serTokenId(String tokenId){
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
