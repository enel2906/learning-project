package org.example.test;

import org.example.app.api.AddStudentAPI;
import org.example.app.model.Student;
import org.example.app.reponse.AddStudentResponse;
import org.example.app.request.AddStudentRequest;

public class Main {

    public static void main(String[] args)  {

        Student student = new Student("Minh",20,"math");
        Student student2 = new Student("Son1",30,"abc");
        System.out.println(student.hashCode());


        changeStudent(student,student2);
//        System.out.println(student);
//        System.out.println(student2);


//        System.out.println(student);
//        System.out.println(student2);
//        int number = 5;
//        number = changeNumber(number);
    }

    private static void changeStudent(Student student1, Student student2) {
        student1.setAge(30);
        student2 = new Student("Son", 18, "literature");

        System.out.println(student1.hashCode());


    }

}
