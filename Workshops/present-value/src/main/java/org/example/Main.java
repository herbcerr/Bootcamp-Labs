package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter your monthly interest rate amount: ");
        double PMT = scanner.nextDouble();
        System.out.printf("Enter your interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.printf("Enter your the amount of years: ");
        int years = scanner.nextInt();
    }
    public static double presentValue(double PMT, double interestRate, int years){

    }
}