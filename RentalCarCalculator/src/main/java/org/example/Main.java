package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //ask for the date and how long
        System.out.printf("Enter the pickup date: ");
        String pickupDate = scanner.next();
        System.out.printf("How long will you be renting?: ");
        int duration = scanner.nextInt();

        //menu for the additional options, ask user yes or no
        System.out.printf("\nOptional Service Packages\n");
        System.out.printf("Would you like an electronic tag at $3.95/day? (yes/no): ");
        String firstOption = scanner.next();
        System.out.printf("Would you like a GPS at $2.95/day? (yes/no): ");
        String secondOption = scanner.next();
        System.out.printf("Would you like roadside assistance at $3.95/day? (yes/no): ");
        String thirdOption = scanner.next();

        //ask user for the age
        System.out.printf("\nAge Inquiry\n");
        System.out.printf("Please provide your age: ");
        int age = scanner.nextInt();

        double totalPayment = totalCost(duration, firstOption, secondOption, thirdOption, age);
        System.out.println("On " + pickupDate + " you will rent a total of " + totalPayment);
    }

    public static double totalCost(int duration, String opt1, String opt2, String opt3, int age){
        //basic and optional choices
        double basicCarRental = duration * 29.99;
        double surcharge = age < 25 ? 1.3 : 1;
        double optCost1 = opt1.equalsIgnoreCase("yes") ? 3.95 * duration : 0;
        double optCost2 = opt2.equalsIgnoreCase("yes") ? 2.95 * duration : 0;
        double optCost3 = opt3.equalsIgnoreCase("yes") ? 3.95 * duration : 0;

        return ((basicCarRental * surcharge) + (optCost1) + (optCost2) + (optCost3));
    }
}