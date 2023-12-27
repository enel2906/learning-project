package org.example.app.service;

import org.example.app.model.Token;
import org.example.app.repository.SessionRepository;

public class SessionService implements ServiceInterface<Token>{
    private SessionService(){

    }

    private static SessionService INSTANCE = new SessionService();

    public static SessionService getINSTANCE() {
        return INSTANCE;
    }
    public Token findByKey(String token) throws Exception {
        return SessionRepository.findById(token);
    }
    public void remove(String token) throws Exception{
        SessionRepository.removeToken(token);
    }
    public boolean isValid(String token) throws Exception {
        return SessionRepository.isValidToken(token);
    }
    public String getUserId(String token){
        return SessionRepository.getUserId(token);
    }

    public long getTimeOfToken(String token) throws Exception {
        return SessionRepository.getTime(token);
    }

    public String createToken(String id, String ipLogin, int role) throws Exception{
        return SessionRepository.createToken(id, ipLogin, role);
    }

    public long getRecentActivity(String token) throws Exception {
        return SessionRepository.getRecentActivity(token);
    }

    public void updateRecentActivity(String token) throws Exception {
        SessionRepository.updateRecentActivity(token);
    }

    public int countIpLogin(String id) throws Exception {
        return SessionRepository.countIpLogin(id);
    }

    public void deleteNonActiveSessions(long timePeriod) throws Exception {
        SessionRepository.deleteNonActiveSessions(timePeriod);
    }

    public int getRoleByToken(String token) throws Exception{
        return SessionRepository.getRoleByToken(token);
    }

}
