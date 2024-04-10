package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the first number: ");
        float firstNumber = scanner.nextFloat();
        System.out.printf("Enter the second number: ");
        float secondNumber = scanner.nextFloat();

        System.out.println("\nPossible calculations:");
        System.out.println("\t(A)dd");
        System.out.println("\t(S)ubtract");
        System.out.println("\t(M)ultiply");
        System.out.println("\t(D)ivide");
        System.out.printf("Please select an option: ");
        String answer = scanner.next();

        if(answer.equalsIgnoreCase("A")){
            System.out.println("\n" + firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
        }
        else if(answer.equalsIgnoreCase("S")){
            System.out.println("\n" + firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
        }
        else if(answer.equalsIgnoreCase("M")){
            System.out.println("\n" + firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
        }
        else if(answer.equalsIgnoreCase("D")){
            System.out.println("\n" + firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));
        }
        else{
            System.out.println("Sorry I don't quite understand");
        }
    }
}