package org.example.app.response.user;

import org.example.app.response.Response;
import org.example.app.response.ResponseData;

public class InforResponse extends ResponseData {
    private String name;
    private int role;
    private int age;

    public InforResponse() {
    }
    public InforResponse(String name, int role, int age){
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Name: "+name+"  Role: "+role+"  Age: "+age;
    }

}
