package org.example.app.api;

import org.example.app.controller.StudentController;
import org.example.app.response.AddStudentResponse;
import org.example.app.request.AddStudentRequest;

public class AddStudentAPI {

    private AddStudentAPI(){

    }
    private static final AddStudentAPI INSTANCE = new AddStudentAPI();

    public static AddStudentAPI getInstance(){
        return INSTANCE;
    }
    public AddStudentResponse execute(AddStudentRequest request){
        String name = request.getName();
        int age = request.getAge();
        String subject = request.getSubject();
        String id = StudentController.getInstance().addStudent(name,age,subject);
        return new AddStudentResponse(id);
    }
}
