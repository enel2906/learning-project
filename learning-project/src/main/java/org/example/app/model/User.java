package org.example.app.model;

import org.example.app.util.Util;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String name;
    private int age;
    private int role;

    private String id;
    private String address;

    public User(String username, String password, String name, int age, int role, String id, String address){
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
        this.id = id;
        this.address = address;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public int getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }



    public void setRole(int role) {
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

    public void setAddress(String address) {
        this.address = address;
    }

}


