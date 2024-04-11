package org.example;

import java.util.Scanner;

//hello
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ask and get user input
        System.out.printf("Enter the first number: ");
        float firstNumber = scanner.nextFloat();
        System.out.printf("Enter the second number: ");
        float secondNumber = scanner.nextFloat();

        //print out menu
        System.out.println("\nPossible calculations:");
        System.out.println("\t(A)dd");
        System.out.println("\t(S)ubtract");
        System.out.println("\t(M)ultiply");
        System.out.println("\t(D)ivide");

        //ask the user which option
        System.out.printf("Please select an option: ");
        String answer = scanner.next();

        //calculations for possible answers
        if(answer.equalsIgnoreCase("A")){
            System.out.println("\n" + firstNumber + " + " + secondNumber + " = " + addNumber(firstNumber, secondNumber));
        }
        else if(answer.equalsIgnoreCase("S")){
            System.out.println("\n" + firstNumber + " - " + secondNumber + " = " + subNumber(firstNumber,secondNumber));
        }
        else if(answer.equalsIgnoreCase("M")){
            System.out.println("\n" + firstNumber + " * " + secondNumber + " = " + multiNumber(firstNumber,secondNumber));
        }
        else if(answer.equalsIgnoreCase("D")){
            System.out.println("\n" + firstNumber + " / " + secondNumber + " = " + divideNumber(firstNumber,secondNumber));
        }
        else{
            System.out.println("Sorry I don't quite understand");
        }
    }

    //math operations into functions
    public static float addNumber (float firstNumber, float secondNumber){
        return firstNumber + secondNumber;
    }
    public static float subNumber (float firstNumber, float secondNumber){
        return firstNumber - secondNumber;
    }
    public static float multiNumber (float firstNumber, float secondNumber){
        return firstNumber * secondNumber;
    }
    public static float divideNumber (float firstNumber, float secondNumber){
        return firstNumber / secondNumber;
    }
}