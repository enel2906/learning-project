package org.example.app.model;

import java.util.List;

public class Teacher {

    private String name;
    private String subject;
    private Integer age;
    private List<String> classes;

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

//    public Teacher(String name, String subject, Integer age, List<String> classes) {
//        this.name = name;
//        this.subject = subject;
//        this.age = age;
//        this.classes = classes;
//    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getClasses() {
        return classes;
    }
}
