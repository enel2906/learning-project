package org.example.app.service;

import org.example.app.model.Token;
import org.example.app.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }
    public Token findByKey(String token) throws Exception {
        return sessionRepository.findById(token);
    }
    public void remove(String token) throws Exception{
        sessionRepository.removeToken(token);
    }
    public boolean isValid(String token) throws Exception {
        return sessionRepository.isValidToken(token);
    }
    public String getUserId(String token){
        return sessionRepository.getUserId(token);
    }

    public long getTimeOfToken(String token) throws Exception {
        return sessionRepository.getTime(token);
    }

    public String createToken(String id, String ipLogin, int role) throws Exception{
        return sessionRepository.createToken(id, ipLogin, role);
    }

    public long getRecentActivity(String token) throws Exception {
        return sessionRepository.getRecentActivity(token);
    }

    public void updateRecentActivity(String token) throws Exception {
        sessionRepository.updateRecentActivity(token);
    }

    public int countIpLogin(String id) throws Exception {
        return sessionRepository.countIpLogin(id);
    }

    public void deleteNonActiveSessions(long timePeriod) throws Exception {
        sessionRepository.deleteNonActiveSessions(timePeriod);
    }

    public int getRoleByToken(String token) throws Exception{
        return sessionRepository.getRoleByToken(token);
    }

    public void deleteAllSessions() throws Exception {
        sessionRepository.deleteAllSession();
    }

}
