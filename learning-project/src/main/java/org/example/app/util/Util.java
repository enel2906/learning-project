package org.example.app.util;

import java.time.LocalTime;
import java.util.*;

public class Util {
    public static Integer getRandomInteger(int minRange, int maxRange){
        return RandomGenerator.getRandomInt(minRange, maxRange);
    }

    public static String getRandomString(){
        return UUID.randomUUID().toString();
    }



    public static void sleep(Integer timeSleep){
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static  ArrayList<String> convertSettoArrayList(Set<String> set){
        return new ArrayList<>(set);
    }

    public static boolean isNull(Object object ){
        return object == null;
    }

    public static boolean isNotNull(Object object ){
        return !isNull(object);
    }

    public static long convertTimeToSecond(LocalTime localTime){
        long hour = localTime.getHour();
        long minute = localTime.getMinute();
        long second = localTime.getSecond();

        return hour*3600 + minute*60 + second;
    }

    public static boolean isNotContainCapitalLetter(String s){
        if(isNull(s)){
            return true;
        }
        String sLower = s.toLowerCase();
        return s.equals(sLower);
    }

    public static boolean isPositive(int number){
        if(isNull(number)){
            return false;
        }
        return number > 0;
    }

    public static boolean isNotPositive(int number){
        return !isPositive(number);
    }
}
