package org.example.app;

import org.example.app.api.user.LoginAPI;
import org.example.app.controller.UserController;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;
import org.example.app.response.user.LoginResponse;
import org.example.app.thread.user.ScanTimeValid;
import org.example.app.thread.user.UpdateTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        UpdateTime updateTime = new UpdateTime();
        ScanTimeValid scanTimeValid = new ScanTimeValid();
        updateTime.start();
        scanTimeValid.start();


        UserController.getInstance().addUser("minh123", "1234", "Minh", 20, "intern");
        UserController.getInstance().addUser("Son12", "3244", "Sơn", 26, "leader");
        UserController.getInstance().addUser("john123", "password123", "John Smith", 25, "employee");
        UserController.getInstance().addUser("alice92", "securepwd", "Alice Johnson", 30, "manager");
        UserController.getInstance().addUser("jenny456", "pass123", "Jenny Brown", 28, "employee");
        UserController.getInstance().addUser("david789", "david123", "David Lee", 35, "manager");
        UserController.getInstance().addUser("sarah567", "sarahpass", "Sarah Williams", 26, "intern");
        UserController.getInstance().addUser("alex90", "alexpass", "Alex Green", 29, "employee");
        UserController.getInstance().addUser("emily321", "emilypwd", "Emily Davis", 31, "manager");
        UserController.getInstance().addUser("michael555", "mikepass", "Michael Johnson", 27, "intern");



        LoginRequest requestLogin1 = new LoginRequest("Son12", "3244");
        LoginResponse loginResponse2 = LoginAPI.getInstance().execute(requestLogin1);
        String token1 = loginResponse2.getToken();
        System.out.println(token1);

        LoginRequest requestLogin2 = new LoginRequest("david789", "david123");
        LoginResponse loginResponse = LoginAPI.getInstance().execute(requestLogin2);






    }




}
