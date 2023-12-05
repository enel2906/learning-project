package org.example.app.datestudy;

import org.example.app.datestudy.model.DateConvert;

import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        DateConvert date1 = new DateConvert(str1);
        DateConvert date2 = new DateConvert(str2);

        Period period = Period.between(date1.getDate(), date2.getDate());
        System.out.println(period);
    }
}
