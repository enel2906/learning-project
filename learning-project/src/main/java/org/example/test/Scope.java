package org.example.test;

import org.example.app.model.Student;
import org.example.app.model.Teacher;

import java.util.ArrayList;

public class Scope {
    public static void main(String[] args)
    {
        int dayOfWeek = 6;
        switch(dayOfWeek) {
            case 0:
                System.out.println("Sunday");

            case 6:
                System.out.println("Saturday");
        }

    }
}



