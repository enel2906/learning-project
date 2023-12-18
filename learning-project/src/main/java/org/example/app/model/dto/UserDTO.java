package org.example.app.model.dto;

public class UserDTO {
    private String name;
    private int role;
    private int age;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDTO(String name, int role, int age,String address) {
        this.name = name;
        this.role = role;
        this.age = age;
        this.address = address;
    }
}
