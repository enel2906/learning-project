package org.example.app.thread;

import org.example.app.model.Student;
import org.example.app.util.Util;

public class StudentsRacing extends Thread{
    private static final Integer DISTANCE_NEEDED = 40;
    private static final Integer TIME_SLEEP = 2000;
    private static final Integer MIN_SPEED = 3;
    private static final Integer MAX_SPEED = 10;
    private Student student;
    public StudentsRacing(Student student){
        this.student = student;
    }

    public void run(){
        Util util = new Util();
        int distanceRemain = DISTANCE_NEEDED;
        int distanceRunInOnePeriod;
        int timeSleep = TIME_SLEEP;
        String nameStudent = student.getName();
        do{
            distanceRunInOnePeriod = util.getRandomInteger(MIN_SPEED, MAX_SPEED);
            distanceRemain -= distanceRunInOnePeriod;

            if(distanceRemain <= 0){
                System.out.println(nameStudent +" finished the race!!!");
                break;
            }
            System.out.println(nameStudent+" have ran "+distanceRunInOnePeriod+"m");
            util.sleep(timeSleep);
        }while(distanceRemain > 0);



    }

}