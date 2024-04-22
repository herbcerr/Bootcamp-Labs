package org.example;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        CellPhone userPhone = new CellPhone();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your serial number? ");
        userPhone.setSerialNumber(scanner.nextLine());
        System.out.println("What model is the phone? ");
        userPhone.setModel(scanner.nextLine());
        System.out.println("Who is the carrier? ");
        userPhone.setCarrier(scanner.nextLine());
        System.out.println("What is the phone number? ");
        userPhone.setPhoneNumber(scanner.nextLine());
        System.out.println("Who is the owner of the phone? ");
        userPhone.setOwner(scanner.nextLine());

        System.out.println("Your serial number is " + userPhone.getSerialNumber() +
                            ", your model is " + userPhone.getModel() +
                            ", your carrier is " + userPhone.getCarrier() +
                            ", your phone number is " + userPhone.getPhoneNumber() +
                            ", and the owner of the phone is " + userPhone.getOwner());
    }
}
