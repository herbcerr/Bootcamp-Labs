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

        double basicCar = 29.99 * duration;


        //filter the possible calculations from user response
        if(firstOption.equalsIgnoreCase("no") && secondOption.equalsIgnoreCase("no") && thirdOption.equalsIgnoreCase("no") && (age > 25)){
            System.out.printf("You pay this much: $%.2f", basicCar);
        }
        else if(firstOption.equalsIgnoreCase("yes") && secondOption.equalsIgnoreCase("no") && thirdOption.equalsIgnoreCase("no") && (age > 25)){
            System.out.printf("You pay this much: ", basicCar + (duration * 3.95));
        }
    }
}