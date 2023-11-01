package org.example.test;// Java Program to Demonstrate Exception is Thrown
// How the runTime System Searches Call-Stack
// to Find Appropriate Exception Handler

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Class
// ExceptionThrown
class GFG {
    public static void main(String[] args) {
        String type = "moose";
        Object obj = type;
        Integer number = (Integer) obj;
    }
}