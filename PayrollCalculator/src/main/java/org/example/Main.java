package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter how many hours you've worked: ");
        float hours = scanner.nextFloat();
        System.out.println("Enter your hourly rate: ");
        float hourlyRate = scanner.nextFloat();

        if(hours > 40){
            float result =
            System.out.println("Hello " + name + " your gross pay is: " + ((hours - 40) +  (hours * hourlyRate)));

        }

        System.out.println("Hello " + name + " your gross pay is: " + result);
    }
}