package org.example.app.model;

import org.example.app.util.Util;

public class Student extends Teacher{
    private String name;
    private Integer age;
    private String subject;
    private String id;
    public static final Integer MIN_NUMER_ID = 0;
    public static final Integer MAX_NUMBER_ID = 2;
    private String createId(){
       return Util.getRandomString();
    }

    public Student(String id, String name, int age, String subject){
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.id = id;
    }

    public Student(String name, int age, String subject){
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.id = createId();
    }

    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public String getSubject(){
        return subject;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return this.getId()+" "+this.getName()+" "+this.getAge()+
                " "+this.getSubject();
    }
}
