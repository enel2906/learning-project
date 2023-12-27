package org.example.app.thread.user;

import org.example.app.service.SessionService;
import org.example.app.util.Util;

public class LogoutPeriod extends Thread {
    private static final int LOGOUT_PERIOD = 3; //time check in minutes

    private static final int CHECK_PERIOD = 30000; //time sleep in millisecond

    public void run() {
        while(true){
            try {
                scanAndRemoveInvalidTime();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Util.sleep(CHECK_PERIOD);
        }
    }

    public void scanAndRemoveInvalidTime() throws Exception {
        SessionService.getINSTANCE().deleteNonActiveSessions(LOGOUT_PERIOD);
    }

}