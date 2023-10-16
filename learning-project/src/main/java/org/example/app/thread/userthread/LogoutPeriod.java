package org.example.app.thread.userthread;

import org.example.app.controller.UserController;
import org.example.app.util.Util;

public class LogoutPeriod extends Thread{
    private static final int LOGOUT_PERIOD = 30000;

    private String token;
    public LogoutPeriod(String token) {
        this.token = token;
    }
    public void run(){
        Util.sleep(LOGOUT_PERIOD);
        String name = UserController.getInstance().findUserByToken(token).getName();
        UserController.getInstance().logoutUser(token);
        System.out.println("User "+name+" have logged out!");
    }
}
