package org.example.app.response.user;

import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.example.app.constant.ExceptionCode.*;
@ResponseBody
public class InforResponse extends ResponseData {
    private String name;
    private int role;
    private int age;

    public InforResponse() {
        super();
    }
    public InforResponse(String name, int role, int age){
        super(SUCCESS.getCode(), "Get Information successfully!");
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public InforResponse(int code, String message){
        super(code, message);
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
