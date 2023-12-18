package org.example.app.model;

import org.example.app.util.Util;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Token {
    private String tokenId;

    private String userId;

    private String ipLogin;

    private int role;

    public int getRole() {
        return role;
    }

    public Token(String tokenId, String userId, String ipLogin, LocalDateTime time, long recentActivity, int role) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.ipLogin = ipLogin;
        this.role = role;
        this.time = time;
        this.recentActivity = recentActivity;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getIpLogin() {
        return ipLogin;
    }

    private LocalDateTime time;
    private long recentActivity;

    public long getRecentActivity() {
        return recentActivity;
    }

    public void setRecentActivity(long recentActivity) {
        this.recentActivity = recentActivity;
    }

    public Token(String tokenId, String userId, String ipLogin, LocalDateTime time, long recentActivity) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.ipLogin = ipLogin;
        this.time = time;
        this.recentActivity = recentActivity;
    }

    public void setIpLogin(String ipLogin) {
        this.ipLogin = ipLogin;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Token(String tokenId, String userId, String ipLogin) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.ipLogin = ipLogin;
    }

    public Token(String tokenId, String userId, String ipLogin, LocalDateTime time) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.ipLogin = ipLogin;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }



    public Token(String userId){
        this.userId = userId;
        this.tokenId = createTokenId();
        this.time = LocalDateTime.now();
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
