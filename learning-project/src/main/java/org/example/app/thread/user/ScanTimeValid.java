package org.example.app.thread.user;

import org.example.app.controller.TokenController;
import org.example.app.util.Util;

public class ScanTimeValid extends Thread{

    private static final int TIME_LIMIT = 100000;
    private static final int TIME_SLEEP = 50000;
    public void run(){
        Util.sleep(TIME_SLEEP);
        TokenController.getInstance().scanTimeValid(TIME_LIMIT);
    }
}
