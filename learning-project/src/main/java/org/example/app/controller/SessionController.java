package org.example.app.controller;

import org.example.app.service.SessionService;
import org.example.app.exception.BusinessException;

import static org.example.app.constant.ExceptionCode.INVALID;
import static org.example.app.constant.ExceptionCode.UNKNOWN;

public class SessionController {
    private SessionController(){

    }

    private static SessionController INSTANCE = new SessionController();
    public static SessionController getInstance(){
        return INSTANCE;
    }

    public String getUserId(String tokenId) throws Exception {
        return SessionService.getInstance().getUserId(tokenId);
    }

    public String createSession(String id, String ipLogin, int role) throws Exception{
        return SessionService.getInstance().createToken(id, ipLogin, role);
    }

    public void removeToken(String token) throws Exception{
            SessionService.getInstance().removeToken(token);
    }

    public boolean isValidToken(String token) throws Exception {
            return SessionService.getInstance().isValidToken(token);
    }

    public long getTimeOfToken(String tokenId) throws Exception {
        return SessionService.getInstance().getTimeOfToken(tokenId);
    }

    public long getCurrentActivity(String token) throws Exception {
        return SessionService.getInstance().getRecentActivity(token);
    }

    public void updateCurrentActivity(String token) throws Exception {
        SessionService.getInstance().updateRecentActivity(token);
    }

    public int countIdLogin(String id) throws Exception {
        return SessionService.getInstance().countIpLogin(id);
    }
    public void deleteNonActiveSessions(long timePeriod) throws Exception {
        SessionService.getInstance().deleteNonActiveSessions(timePeriod);
    }
    public int getRoleByToken(String token) throws Exception{
        return SessionService.getInstance().getRoleByToken(token);
    }

}
