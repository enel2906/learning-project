package org.example.test;

public class PassByReferenceExample {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Before method call: " + str);

        appendWorld(str);

        System.out.println("After method call: " + str);
    }

    public static void appendWorld(String s) {
        s += " World";
        System.out.println("Inside method: " + s);
    }
}