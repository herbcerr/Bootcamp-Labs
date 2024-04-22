package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        homeScreen();
    }

    //screen for Home
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            System.out.println("""
                    -------------------Welcome to the library--------------------
                    Please Select one of the options:
                    1) Show Available Books
                    2) Show Checked Out Books
                    3) Exit""");
            var input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("------------------------Available books----------------------");
                    library.displayAvailableBooks();
                    break;
                case "2":
                    System.out.println("-----------------------Check Out Books-----------------------");
                    library.displayCheckedOutBooks();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Please select from the options listed above");
            }
        }
    }
}