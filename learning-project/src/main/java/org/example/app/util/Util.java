package org.example.app.util;

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
}
