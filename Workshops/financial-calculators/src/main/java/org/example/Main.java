package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter your loan amount: ");
        double principle = scanner.nextDouble();
        System.out.printf("Enter your interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.printf("Enter your the amount of years: ");
        int years = scanner.nextInt();
        double monthlyPay = monthlyPayment(principle, interestRate, years);
        double totalInterest = (monthlyPay * 12 * years) - principle;

        System.out.printf("Your monthly payment would be $%.2f with a total interest of $%.2f", monthlyPay, totalInterest);
    }
    public static double monthlyPayment(double principle, double interestRate, int years){
        double rate = interestRate / 12 / 100;
        int numberMonth = years * 12;
        double basePower = Math.pow(1 + rate, numberMonth);
        return (principle * (rate * basePower / (basePower - 1)));
    }
}