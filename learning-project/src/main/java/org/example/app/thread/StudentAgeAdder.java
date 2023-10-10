//package org.example.app.thread;
//
//import org.example.app.model.Student;
//import org.example.app.repository.StudentRepository;
//import org.example.app.util.Util;
//
//import java.util.Map;
//
//public class StudentAgeAdder extends Thread{
//    private static Integer MAX_AGE = 25;
//    private static final Integer TIME_SLEEP = 1000;
//
//    private Student student;
//
//    public void run(){
//        for(Map.Entry<String, Student> student : StudentRepository.getEntryMap()){
//            Student studentValue = student.getValue();
//            Integer ageValue = studentValue.getAge();
//            while(ageValue <= MAX_AGE){
//                ageValue++;
//                studentValue.setAge(ageValue);
//                Util.sleep(TIME_SLEEP);
//            }
//        }
//    }
//
//}
