package org.example.app.repository;

import org.example.app.model.Student;
import org.example.app.util.Util;

import java.util.*;

public class StudentRepository {
    static int a = 1;
    private static final Integer MIN_STUDENT = 0;
    private static final Integer MAX_STUDENT = 100;
    private static final String NAME_ID = "name";
    private static final String AGE_ID = "age";
    private static final String SUBJECT_ID = "subject";
    private static Map<String, Map<String, Object>> studentsMap = new HashMap<>();

    public static String addStudent(Student student){
        String id = Util.getRandomString();
        Map<String, Object> subMap = convertFromStudent(student);

        studentsMap.put(id, subMap);
        return id;
    }


    public static void removeStudent(String id){
        studentsMap.remove(id);
    }

    public static Object getName(int id){
        return studentsMap.get(id).get(NAME_ID);
    }
    public static Object getAge(int id){
       return studentsMap.get(id).get(AGE_ID);
    }

    public static Object getSubject(int id){
        return studentsMap.get(id).get(SUBJECT_ID);
    }

    public static Student findStudentByID(String id){
        Map<String, Object> subMap = studentsMap.get(id);
        return convertFromEntry(subMap);
    }

    public static ArrayList<Student> findStudentByName(String name){
        ArrayList<Student> students = new ArrayList<>();
        for(Map.Entry<String, Map<String, Object>> keyValue : studentsMap.entrySet()){
            String nameValue = (String) keyValue.getValue().get(NAME_ID);
            if(name.equals(nameValue)){
                Student student = convertFromEntry(keyValue.getValue());
                students.add(student);
            }
        }

        return students;
    }

    public static ArrayList<Student> findStudentByAge(int age){
        ArrayList<Student> students = new ArrayList<>();
        for(Map.Entry<String, Map<String, Object>> keyValue : studentsMap.entrySet()){
            int ageValue = (int) keyValue.getValue().get(AGE_ID);
            if(age == ageValue){
                Student student = convertFromEntry(keyValue.getValue());
                students.add(student);
            }
        }

        return students;
    }

    public static Student convertFromEntry(Map<String, Object> keyValue){
        String name = (String) keyValue.get(NAME_ID);
        int age = (int) keyValue.get(AGE_ID);
        String subject = (String) keyValue.get(SUBJECT_ID);
        return new Student(name, age, subject);
    }
    public static Map<String, Object> convertFromStudent(Student student){
        String name = student.getName();
        int age = student.getAge();
        String subject = student.getSubject();

        Map<String, Object> result = new HashMap<>();
        result.put(NAME_ID, name);
        result.put(AGE_ID, age);
        result.put(SUBJECT_ID, subject);
        return result;
    }
    public static ArrayList<String> collectKeyInMap(){
        Set<String> setKey = studentsMap.keySet();
        ArrayList<String> keys = Util.convertSettoArrayList(setKey);
        return keys;
    }

    public static void changeAgeOfStudent(String id, int ageChange){
        Map<String, Object> subMap = studentsMap.get(id);
        int ageValue = (int) subMap.get(AGE_ID);
        ageValue += ageChange;
        subMap.put(AGE_ID, ageValue);

        studentsMap.put(id, subMap);
    }


    public void displayStudent(Student student){
        System.out.println(student.toString());
    }


    public static Set<Map.Entry<String, Map<String, Object>>> getEntryMap(){
        return studentsMap.entrySet();
    }






//    public static void printValueInMap() {
////        System.out.printf("|%-8s|%-8s|  %-6s|  %-8s|\n", "  ID", "  NAME", "AGE", "SUBJECT");
//        for (Map.Entry<String,Student> keyValue : studentsMap.entrySet()) {
//            System.out.println(
//                    keyValue.getValue().getName()+" "+
//                    keyValue.getValue().getAge()+" "+
//                    keyValue.getValue().getSubject());
//        }
//    }



}

//    public static Student getRandomStudent(){
//        ArrayList<String> keys = collectKeyInMap();
//
//        int firstIndex = 0;
//        int lastIndex = keys.size()-1;
//        int index = Util.getRandomInteger(firstIndex, lastIndex);
//
//        String id = keys.get(index);
//
//        Student student = findStudent(id);
//
//        return student;
//    }




