package org.example.app.response.user;

import org.example.app.response.Response;
import org.example.app.response.ResponseData;

public class InforResponse extends ResponseData {
    private String name;
    private String role;
    private int age;

    public InforResponse() {
    }
    public InforResponse(String name, String role, int age){
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
