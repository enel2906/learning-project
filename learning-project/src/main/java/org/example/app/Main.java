package org.example.app;

import org.example.app.api.AddStudentAPI;
import org.example.app.api.userAPI.GetInforAPI;
import org.example.app.api.userAPI.LoginAPI;
import org.example.app.api.userAPI.LogoutAPI;
import org.example.app.controller.StudentController;
import org.example.app.controller.UserController;
import org.example.app.model.Student;
import org.example.app.reponse.AddStudentResponse;
import org.example.app.reponse.userreponse.InforReponse;
import org.example.app.reponse.userreponse.LoginReponse;
import org.example.app.reponse.userreponse.LogoutReponse;
import org.example.app.repository.UserRepository;
import org.example.app.request.AddStudentRequest;
import org.example.app.request.userrequest.InforRequest;
import org.example.app.request.userrequest.LoginRequest;
import org.example.app.request.userrequest.LogoutRequest;
import org.example.app.thread.userthread.LogoutPeriod;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
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

        LoginRequest request1 = new LoginRequest("Son12", "3244");
        LoginReponse reponse1 = LoginAPI.getInstance().execute(request1);
        String token1 = reponse1.getToken();
        LogoutPeriod logoutPeriod = new LogoutPeriod(token1);
        logoutPeriod.start();
        System.out.println(token1);

        InforRequest request2 = new InforRequest(token1);
        InforReponse reponse2 = GetInforAPI.getInstance().execute(request2);
        System.out.println(reponse2.getName()+" "+reponse2.getRole()+" "+reponse2.getAge());

//        LogoutRequest logoutRequest = new LogoutRequest(token1);
//        LogoutReponse logoutReponse = LogoutAPI.getInstance().execute(logoutRequest);

        ;



////        StudentController.getInstance().addStudent("Minh", 20, "math");
//        AddStudentRequest request = new AddStudentRequest("Minh",20,"math");
//        AddStudentResponse response = AddStudentAPI.getInstance().execute(request);
//        System.out.println(response.getId());
//
//        System.out.println(request.hashCode());
    }




}
