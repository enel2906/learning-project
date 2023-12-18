package org.example.app.service;

import org.example.app.repository.SessionRepository;

public class SessionService {
    private SessionService(){

    }

    private static SessionService INSTANCE = new SessionService();

    public static SessionService getInstance(){
        return INSTANCE;
    }

    public String getUserId(String token){
        return SessionRepository.getUserId(token);
    }

    public boolean isValidToken(String token) throws Exception{
        return SessionRepository.isValidToken(token);
    }

    public void removeToken(String token) throws Exception{
        if(!isValidToken(token)){
            System.out.println("token is invalidddddddddd");
            return;
        }
       SessionRepository.removeToken(token);
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
