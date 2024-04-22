package org.example;

import java.util.Scanner;

public class Library {
    public static Book[] books = {
            new Book(1, "978-1-7334-2609-4", "Pikachu"),
            new Book(2, "978-0-6823-9876-7", "Bulbasaur"),
            new Book(3, "978-4-1233-3436-2", "Cataperie"),
            new Book(4, "978-8-8963-0986-1", "Venusaur"),
            new Book(5, "978-2-0923-0976-2", "Ivysaur"),
            new Book(6, "978-9-6106-3243-5", "Squirtle"),
            new Book(7, "978-4-9023-2343-7", "Charmander"),
            new Book(8, "978-2-4843-7624-6", "Charmeleon"),
            new Book(9, "978-1-7773-0983-2", "Wartortle"),
            new Book(10, "978-0-1293-0874-9", "Bastoise"),
            new Book(11, "978-9-0893-1233-2", "Charizard"),
            new Book(12, "978-0-0846-5474-3", "Mortal Combat"),
            new Book(13, "978-1-7743-8722-6", "Sonic The Hedgehog"),
            new Book(14, "978-2-7655-0787-5", "Zelda"),
            new Book(15, "978-3-2343-4643-2", "Max Payne"),
            new Book(16, "978-4-0865-9785-1", "Hitman"),
            new Book(17, "978-8-2465-1386-0", "Atomic Bomberman"),
            new Book(18, "978-0-6456-1785-9", "Pacman"),
            new Book(19, "978-2-0983-8655-6", "The Sims"),
            new Book(20, "978-7-3598-0934-8", "Space Invader"),
    };


    public void displayAvailableBooks() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a book to check out: \n ");
        for(Book books : books){
            if(!books.isCheckout()){
                System.out.println("ID: " + books.getId() + ", ISBM: " + books.getIsbm() + ", Title of the Book: " + books.getTitle());
            }
        }
        System.out.println("Would you like to check out a book today? (Yes / No): ");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            checkOut();
        }
        else if(answer.equalsIgnoreCase("no")){
            System.out.println("Returning to home page...");
        }
        else{
            System.out.println("Lost?");
        }
    }

    public void displayCheckedOutBooks() {
        Scanner scanner = new Scanner(System.in);
        for (Book books : books){
            if(books.isCheckout()){
                System.out.println("ID: " + books.getId() + ", ISBM: " + books.getIsbm() + ", Title of the Book: " + books.getTitle() + ", Checkout by : " + books.getCheckOutTo());
            }
        }
        System.out.println("Press ( C ) to check in a book OR ( X ) to go back to Home Screen: ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("C")){
            checkIn();
        }
        else if(answer.equalsIgnoreCase("x")){
            System.out.println("Returning to home page...");
        }
        else{
            System.out.println("Lost?");
        }
    }

    //methods
    public void checkOut(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Select the ID of the book you would like to checkout: ");
        int bookId = scanner.nextInt();
        for (Book books : books) {
            if(bookId == books.getId()){
                books.setCheckout(true);
                books.setCheckOutTo(name);
                System.out.println(name + " checkout: " + books.getTitle());
            }
        }
    }

    public void checkIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the book you would like to check in: ");
        int bookId = scanner.nextInt();
        for (Book books : books) {
            if(bookId == books.getId()){
                books.setCheckout(false);
                System.out.println("Successfully returned: " + books.getTitle());
            }
        }
    }
}
