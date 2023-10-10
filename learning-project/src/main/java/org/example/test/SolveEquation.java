package org.example.test;

import java.util.ArrayList;
import java.util.Scanner;

public class SolveEquation {
    public static final double CHECK_DELTA =  0;
    public static final double MULTIPLIER_IN_DELTA = 4;
    public static final double MUPTIPLIER_IN_SOLUTION = 2;

    public static void main(String[] args) {
        new SolveEquation();
    }

    public static Double inputData(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static ArrayList<Double> findSolution(Double firstCoefficient, Double secondCofficient, Double thirdCofficient){
        ArrayList<Double> solutionList = new ArrayList<>();
        double delta = deltaOfEquation(firstCoefficient, secondCofficient, thirdCofficient);
        double deltaSquareRoot = Math.sqrt(delta);
        if(delta > 0){
            double firstSolution = (-secondCofficient - deltaSquareRoot) / (MUPTIPLIER_IN_SOLUTION * firstCoefficient);
            double secondSolution = (-secondCofficient + deltaSquareRoot) / (MUPTIPLIER_IN_SOLUTION * secondCofficient);
            solutionList.add(firstSolution);
            solutionList.add(secondSolution);
            return solutionList;
        }
        if(delta == 0){
            double doubleSolution = -secondCofficient / (MUPTIPLIER_IN_SOLUTION * firstCoefficient);
            solutionList.add(doubleSolution);
        }
        return solutionList;
    }

    public static void printSolution(ArrayList<Double> solutionList){
        if(solutionList.isEmpty()){
            //TODO print phuong trinh vo nghiem
            return;
        }
        //TODO print phuong trinh co nghiem + solutionList
    }

    public static double deltaOfEquation(Double firstCoefficient, Double secondCofficient, Double thirdCofficient){
        return secondCofficient * secondCofficient - MULTIPLIER_IN_DELTA * firstCoefficient * thirdCofficient;
    }

    public SolveEquation(){
        Double firstCoefficent = inputData();
        Double secondCoeficient = inputData();
        Double thirdCoefficient = inputData();

        ArrayList<Double> solutionList = findSolution(firstCoefficent, secondCoeficient, thirdCoefficient);
        printSolution(solutionList);
    }


}