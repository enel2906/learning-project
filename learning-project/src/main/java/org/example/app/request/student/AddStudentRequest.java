package org.example.app.request.student;

public class AddStudentRequest {

    public AddStudentRequest(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }
    private String name;
    private int age;

    private String subject;

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
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void  validateName (){
        if(name.equals("Minh")){
            System.out.println("Bo qua");
        }
    }
}
