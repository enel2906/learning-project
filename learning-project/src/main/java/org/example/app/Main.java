package org.example.app;

import org.example.app.api.AddStudentAPI;
import org.example.app.controller.StudentController;
import org.example.app.model.Student;
import org.example.app.reponse.AddStudentResponse;
import org.example.app.request.AddStudentRequest;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        StudentController.getInstance().addStudent("Minh", 20, "math");
        AddStudentRequest request = new AddStudentRequest("Minh",20,"math");
        AddStudentResponse response = AddStudentAPI.getInstance().execute(request);
        System.out.println(response.getId());

        System.out.println(request.hashCode());
      }




}
