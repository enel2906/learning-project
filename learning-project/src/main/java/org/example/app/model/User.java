package org.example.app.model;

import org.example.app.util.Util;

public class User {
    private String username;
    private String password;
    private String name;
    private int age;
    private String role;
    private String id;

    public String createId(){
        return Util.getRandomString();
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
    public User(String username, String password, String name, int age, String role){
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
        this.id = createId();
    }

    public User(String username, String password, String name, int age, String role, String id){
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
