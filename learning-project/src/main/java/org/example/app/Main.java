package org.example.app;

import org.example.app.api.user.GetInforAPI;
import org.example.app.api.user.LoginAPI;
import org.example.app.controller.UserController;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.request.user.LoginRequest;
import org.example.app.response.Response;
import org.example.app.response.user.*;
import org.example.app.thread.user.LogoutPeriod;

public class Main {

    public static void main(String[] args) {

        LogoutPeriod logoutPeriod = new LogoutPeriod();
        logoutPeriod.start();

        UserController.getInstance().addUser("minh123", "1234", "Minh", 20, "intern");
        UserController.getInstance().addUser("Son12", "3244", "Sơn", 26, "leader");
        UserController.getInstance().addUser("john123", "password123", "John Smith", 25, "employee");
        UserController.getInstance().addUser("alice92", "securepwd", "Alice Johnson", 30, "manager");
        UserController.getInstance().addUser("jenny456", "pass123", "Jenny Brown", 28, "employee");
        UserController.getInstance().addUser("David789", "david1234", "David Lee", 35, "manager");
        UserController.getInstance().addUser("sarah567", "sarahpass", "Sarah Williams", 26, "intern");
        UserController.getInstance().addUser("alex90", "alexpass", "Alex Green", 29, "employee");
        UserController.getInstance().addUser("emily321", "emilypwd", "Emily Davis", 31, "manager");
        UserController.getInstance().addUser("michael555", "mikepass", "Michael Johnson", 27, "intern");

//            LoginRequest requestLogin1 = new LoginRequest("Son12", "3244");
//            LoginResponse loginResponse1 = LoginAPI.getInstance().execute(requestLogin1);
//
//            InforRequest inforRequest = new InforRequest(null);
//            Request request = new Request(inforRequest);
//            Response inforResponse = GetInforAPI.getInstance().execute(request);
//            InforResponse inforResponse1 = ( InforResponse) inforResponse.getResponseData();
//            System.out.println(inforResponse.getCode()+" "+inforResponse.getMessage());

//            LoginRequest loginRequest1 = new LoginRequest("Son12", "3244");
//            Request request1 = new Request(loginRequest1);
//            Response response1 = LoginAPI.getInstance().execute(request1);
//            System.out.println(response1.getCode()+" "+response1.getMessage()+" "+response1.getResponseData());

        LoginRequest loginRequest2 = new LoginRequest("David789", "david1234");
        Request request2 = new Request(loginRequest2);
        Response response2 = LoginAPI.getInstance().execute(request2);
        System.out.println(response2.getCode() + " " + response2.getMessage());

//            LoginResponse loginResponse2 = (LoginResponse) response2.getResponseData();
//            System.out.println(response2.getCode()+" "+response2.getMessage()+" ");
//
//            InforRequest inforRequest1 = new InforRequest(null);
//            Request request3 = new Request(inforRequest1);
//            Response response3 = GetInforAPI.getInstance().execute(request3);
//            System.out.println(response3.getCode()+" "+response3.getMessage()+" "+response3.getResponseData());


    }

}

