package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Screens {
    private final Scanner scanner = new Scanner(System.in);

    public void displayHome(){
        while(true) {
            System.out.println("""
                    ----------Welcome to the Home Screen--------
                    D) Add Deposit
                    P) Make Payment (Debit)
                    L) Ledger
                    X) Exit
                    Please enter one of the options listed above!""");
            String userInput = scanner.nextLine();
            switch (userInput.toLowerCase()) {
                case "d":
                    addDeposit();
                    break;
                case "p":
                    makePayment();
                    break;
                case "l":
                    ledgerInterface();
                    break;
                case "x":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry that's not an option");
            }
        }
    }

    public void addDeposit(){
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedDate = todayDate.format(formatDate);
        LocalTime todayTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatedTime = todayTime.format(formatTime);

        System.out.println("Please enter the required information we need before we start ");
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Now enter the amount you would like to deposit(Ex:$45.75) = $");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Transaction transaction = new Transaction(formatedDate, formatedTime, description, vendor, amount);
        FileManager.writeProductToFile(transaction);
    }

    public void makePayment(){
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedDate = todayDate.format(formatDate);
        LocalTime todayTime = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatedTime = todayTime.format(formatTime);

        System.out.println("Please enter the required information we need before we start ");
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Now enter the amount you would like to make payment(Ex:$-45.75) = $");
        double amount = -(scanner.nextDouble());
        scanner.nextLine();


        Transaction transaction = new Transaction(formatedDate, formatedTime, description, vendor, amount);
        FileManager.writeProductToFile(transaction);
    }

    public void ledgerInterface(){
        boolean x = true;
        while(x) {
            System.out.println("""
                    ===========Ledger==========
                    A) All
                    D) Deposits
                    P) Payments
                    R) Reports
                    H) Home
                    Please enter one of the options listed above!""");
            String userInput = scanner.nextLine();
            switch (userInput.toLowerCase()) {
                case "a":
                    displayTransaction();
                    break;
                case "d":
                    displayDeposits();
                    break;
                case "p":
                    displayPayments();
                    break;
                case "r":
                    reportsInterface();
                    break;
                case "h":
                    x = false;
                    break;
                default:
                    System.out.println("Sorry that isn't listed above in options!");
            }
        }
    }

    public void reportsInterface(){
        boolean x = true;
        while(x) {
            System.out.println("""
                    ---------Reports---------
                    1) Month To Date
                    2) Previous Month
                    3) Year To Date
                    4) Previous Year
                    5) Search By Vendor
                    0) Back
                    Please pick one of the numbers listed above""");
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    monthToDate();
                    break;
                case 2:
                    previousMonth();
                    break;
                case 3:
                    yearToDate();
                    break;
                case 4:
                    previousYear();
                    break;
                case 5:
                    searchByVendor();
                    break;
                case 0:
                    scanner.nextLine();
                    x = false;
                    break;
                default:
                    System.out.println("not sure how we got here");
                    break;
            }
        }
    }

    public void monthToDate(){
        LocalDate currentMonth = LocalDate.now();
        for(Transaction transaction : FileManager.showTransaction()){
            int month = transaction.getDate().getMonthValue();
            int year = transaction.getDate().getYear();
            if (currentMonth.getMonth().equals(Month.of(month)) && currentMonth.getYear() == year) {
                System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void previousMonth(){
        LocalDate current = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = current.withDayOfMonth(1);
        // Calculate the first day of the previous month
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        // Get the month and year of the previous month
        Month previousMonth = firstDayOfPreviousMonth.getMonth();
        for(Transaction transaction : FileManager.showTransaction()){
            int month = transaction.getDate().getMonthValue();
            int year = transaction.getDate().getYear();
            if (previousMonth.equals(Month.of(month)) && current.getYear() == year) {
                System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void yearToDate(){
        LocalDate currentMonth = LocalDate.now();
        for(Transaction transaction : FileManager.showTransaction()){
            int month = transaction.getDate().getMonthValue();
            int year = transaction.getDate().getYear();
            if (currentMonth.getMonth().equals(Month.of(5)) && currentMonth.getYear() == year) {
                System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void previousYear(){
        LocalDate currentDate = LocalDate.now();

        // Get the previous year
        LocalDate previousYearDate = currentDate.minusYears(1);

        // Get the year value of the previous year
        int previousYear = previousYearDate.getYear();
        for(Transaction transaction : FileManager.showTransaction()){
            int year = transaction.getDate().getYear();
            if (previousYear == year) {
                System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void searchByVendor(){
        System.out.println("Type in the name of the vendor you are searching for:");
        scanner.nextLine();
        String vendorName = scanner.nextLine();
        for (Transaction transaction : FileManager.showTransaction()) {
            if (transaction.getVendor().toLowerCase().contains(vendorName.toLowerCase())) {
                System.out.printf("Date: %s|Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void displayDeposits(){
        for(Transaction transaction : FileManager.showTransaction()){
            if(transaction.getAmount() >= 0){
                System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void displayPayments(){
        for(Transaction transaction : FileManager.showTransaction()){
            if(transaction.getAmount() <= 0){
                System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public void displayTransaction(){
        System.out.println("-----------------All Entries-------------------");
        for(Transaction transaction : FileManager.showTransaction()){
            System.out.printf("Date: %s |Time: %s|Description: %s|Vendor: %s|Amount: %.2f\n",
                    transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
        }
    }
}
