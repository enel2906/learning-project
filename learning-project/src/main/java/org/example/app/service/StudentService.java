package org.example.app.service;

import org.example.app.model.Student;
import org.example.app.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Map;

public class StudentService {

    private StudentService(){

    }
    public static final StudentService INSTANCE = new StudentService();

    public static StudentService getInstance(){
        return INSTANCE;
    }
    public String addStudent(String name, int age, String subject){
        Student student = new Student(name, age, subject);
        return StudentRepository.addStudent(student);
    }

    public void removeStudent(String id){
        StudentRepository.removeStudent(id);
    }

    public void updateAgeStudentById(String id, int bonusAge){
        StudentRepository.changeAgeOfStudent(id, bonusAge);
    }


    public Student findStudentById(String id){
        return StudentRepository.findStudentByID(id);
    }

    public ArrayList<Student> getStudentByName(String name){
        return StudentRepository.findStudentByName(name);
    }
    public boolean isExists(String id){
        for(Map.Entry<String, Map<String, Object>> student : StudentRepository.getEntryMap()){
            if(id.equals(student.getKey())){
                return true;
            }
        }
        return false;
    }

}
