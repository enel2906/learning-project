package org.example.app.response.user;

public class InforResponse {
    private String name;
    private String role;
    private int age;

    private int code;

    private String message;


    public InforResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public InforResponse(String name, String role, int age){
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
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
