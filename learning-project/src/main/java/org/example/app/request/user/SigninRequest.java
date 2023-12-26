package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.REQUEST;

public class SigninRequest extends RequestData {
    private String username;
    private String password;
    private String name;
    private int age;
    private int role;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SigninRequest(String username, String password, String name, int age, int role, String address) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
        this.address = address;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void checkValidation(){
        if(     password.length() < 6 ||
                Util.isNull(username) ||
                Util.isNotContainCapitalLetter(name) ||
                Util.isNotPositive(age)
        ){
            throw new BusinessException(REQUEST.getCode(), "Wrong data format!");
        }
    }
}
