package org.example.app.repository;

import org.example.app.model.Teacher;
import org.example.app.util.Util;

import java.util.*;

public class TeachersRepository {
    private static Map<String, Teacher> teachersMap = new HashMap<>();

    public static String addTeacher(Teacher teacher){
        String id = Util.getRandomString();
        teachersMap.put(id, teacher);

        return id;
    }

    public static void removeTeacher(String id){
        teachersMap.remove(id);
    }

    public static Teacher findTeacher(String id){
        return teachersMap.get(id);
    }

    public static List<String> collectKeyInMap(){
        Set<String> keySet = teachersMap.keySet();
        List<String> listKey = new ArrayList<String>(keySet);

        return listKey;
    }

    public static String getTeacherName(String id){
        return teachersMap.get(id).getName();
    }

    public static String getTeacherSubject(String id){
        return teachersMap.get(id).getSubject();
    }


    public static Integer getTeacherAge(String id){
        return teachersMap.get(id).getAge();
    }

    public static List<String> getTeacherClasses(String id){
        return teachersMap.get(id).getClasses();
    }
}
