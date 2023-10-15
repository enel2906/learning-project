package org.example.app.controller;

import org.example.app.model.Student;
import org.example.app.repository.StudentRepository;
import org.example.app.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private StudentController(){
    }
    private static final StudentController INSTANCE = new StudentController();

    public static StudentController getInstance(){
        return INSTANCE;
    }
    public String addStudent(String name, int age, String subject){
       return StudentService.INSTANCE.addStudent(name, age, subject);
    }

    public void removeStudent(String id){
        if(StudentService.INSTANCE.isExists(id)){
            System.out.println("The id isn't exist!!!");
            return;
        }
        StudentService.INSTANCE.removeStudent(id);
    }

    public void updateAgeOfStudent(String id){
        if (!StudentService.INSTANCE.isExists(id)){
            System.out.println("The id isn't exist!!!");
            return;
        }
        Student student = StudentService.INSTANCE.findStudentById(id);

        Scanner scanner = new Scanner(System.in);
        int ageChange = scanner.nextInt();
        System.out.println("Enter the number value you want to change: ");
        int valueChange = scanner.nextInt();
        System.out.println("Information of the student before update age: "+student.toString());
        StudentRepository.changeAgeOfStudent(id, valueChange);
        System.out.println("Information of the student after update age: "+student.toString());
    }

    public void getStudent(String id){
        if(!StudentService.INSTANCE.isExists(id)){
            System.out.println("The id isn't exist!!!");
            return;
        }
        Student student = StudentService.INSTANCE.findStudentById(id);
        System.out.println(student.toString());
    }

    public void findStudentByName(String name){
        ArrayList<Student> students = StudentService.INSTANCE.getStudentByName(name);
        if(students.isEmpty()){
            System.out.println("No student name "+name+"!!!");
            return;
        }
        System.out.println("There are "+students.size()+" students name "+name+":");
        for(Student student : students){
            System.out.println(student.toString());
        }
    }




}
