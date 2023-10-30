package org.example.app.thread.user;

import org.example.app.controller.TokenController;
import org.example.app.service.TokenService;
import org.example.app.util.Util;

import java.util.Map;

public class UpdateTime extends Thread{

    private static final int TIME_UPDATE = 1000;
    public void run(){
        while (true){
            Util.sleep(TIME_UPDATE);
            TokenController.getInstance().updateTimeOfAllToken(TIME_UPDATE);
        }
    }
}
