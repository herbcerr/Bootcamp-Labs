package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileManager {
    private static final String TRANSACTION_FILE = "src/main/resources/transaction.csv";
    public static LocalDateTime today = LocalDateTime.now();
    // display the transaction from the file
    public static ArrayList<Transaction> showTransaction(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        //try-with it cleans up automatically
        try(BufferedReader reader = new BufferedReader(new FileReader(TRANSACTION_FILE))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                //deserialize
                String[] data = line.split("\\|");
                String date = data[0];
                String time = data[1];
                String description = data[2];
                String vendor = data[3];
                double category = Double.parseDouble(data[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, category);
                transactions.add(transaction);
            }
        }
        catch(IOException ex){
            System.out.println("Sorry couldn't read the file.");
        }
        return transactions;
    }

    public static void writeProductToFile(Transaction transaction){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true))){
            String transactionToFile = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            writer.newLine();
            writer.write(transactionToFile);
            //optional message
            System.out.println("Printed successfully!");
        }
        catch(IOException ex){
            System.out.println("Couldn't open the file");
        }
    }

    public static void displayDeposits(){

    }

//    public String transactionToFile(Transaction transaction) {
//        return String.format("%s|%s|%s|%s|%.2f",
//                transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
//    }
}
