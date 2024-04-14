package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter your deposit amount: ");
        double deposit = scanner.nextDouble();
        System.out.printf("Enter your interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.printf("Enter your the amount of years: ");
        int years = scanner.nextInt();
        double futureValue = calc(deposit, interestRate, years);

        System.out.printf("Your future value is $%.2f and your total interest is $%.2f", futureValue, (futureValue-deposit));
    }
    //math calc
    public static double calc(double deposit, double interestRate, int years) {
        // interestRate= 3.57874972 .2 = 3.58
        return Math.pow(1 + (interestRate/365 / 100), (365 * years)) * deposit;
    }
}