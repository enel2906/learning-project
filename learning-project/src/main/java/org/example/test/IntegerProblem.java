package org.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegerProblem{
    public static final Integer MIN_PRIME_NUMBER = 2;
    public static void main(String[] args) {
        Integer inputData = inputData();

        List<Integer> divisors = collectDivisors(inputData);

        List<Integer> digits = collectDigits(inputData);

        Integer sumOfDivisor = sumOfDivisors(divisors);

        Integer sumOfDigits = sumOfDigits(digits);

        print(sumOfDivisor, sumOfDigits);
    }

    public static Integer inputData(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> collectDigits(Integer inputData){
        ArrayList<Integer> digits = new ArrayList<>();
        while(inputData > 0){
            Integer digit = inputData % 10;
            digits.add(digit);
            inputData /= 10;
        }
        return digits;
    }

    public static List<Integer> collectDivisors(Integer inputData){
        ArrayList<Integer> divisors = new ArrayList<>();
        int i = 1;
        while( i <= inputData){
            if(inputData % i == 0){
                divisors.add(i);
            }
            i++;
        }
        return divisors;
    }

    public static Integer sumOfDigits(List<Integer> digits){
        int sumDigits = 0;
        for(int i : digits){
            sumDigits += i;
        }
        return sumDigits;
    }

    public static Integer sumOfDivisors(List<Integer> divisors){
        int sumDivisors = 0;
        for(int i : divisors){
            sumDivisors += i;
        }
        return sumDivisors;
    }

    public static void print(Integer sumOfDivisors, Integer sumOfDigits){
        System.out.println("Sum of Divisors: "+sumOfDivisors);
        System.out.println("Sum of Digits: "+sumOfDigits);
    }
}