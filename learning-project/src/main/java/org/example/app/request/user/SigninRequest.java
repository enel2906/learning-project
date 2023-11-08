package org.example.app.request.user;

import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.util.Util;

import static org.example.app.constant.ApiName.SIGNIN_API_NAME;
import static org.example.app.constant.ExceptionCode.REQUEST;

public class SigninRequest extends RequestData {
    private String username;
    private String password;
    private String name;
    private int age;
    private String role;

    public SigninRequest(String username, String password, String name, int age, String role) {
        super();
        setApiName(SIGNIN_API_NAME);
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void checkValidation(){
        if(     password.length() < 6 ||
                Util.isNull(username) ||
                Util.isNotContainCapitalLetter(name) ||
                Util.isNotPositive(age)
        ){
            throw new BusinessException(REQUEST, "Wrong data format!");
        }
    }
}
