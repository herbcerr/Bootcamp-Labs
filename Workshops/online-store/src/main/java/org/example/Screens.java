package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Screens {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> cart = new ArrayList<>();

    //display home screen
    public void displayHomeInterface(){
        while(true) {
            System.out.println("""
            ---------------Welcome to my online store!--------------
            ( 1 ) Would you like to check out our products?
            ( 2 ) Would you like to see your cart
            ( 3 ) Exit :
            Choose from 1-3 please:""");
            switch (validateInput()) {
                case 1:
                    displayInventory();
                    break;
                case 2:
                    displayBuggy();
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("How did we get here...");
                    break;
            }
        }
    }

    //display products
    public void displayInventory(){
        //display the product
        //print all the product in screen using advanced for loop
        for(Product product : getProduct()){
            System.out.printf("Name: %s|Price: %.2f|Department: %s\n",
                    product.getName(), product.getPrice(), product.getDepartment());
        }

        //prompt the user to search, add, go back to home
        System.out.println("""
        
        --------------List of our beautiful products--------------
        ( 1 ) Filter your products and search
        ( 2 ) Add products to screen
        ( 3 ) Go back to home page!
        Please enter from 1-3 please:""");
        switch(validateInput()){
            case 1:
                searchOption();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                displayHomeInterface();
                break;
            default:
                System.out.println("How did we get here...");
                displayInventory();
                break;
        }
    }

    //displayCart
    public void displayBuggy(){
        System.out.println("---------------Welcome to your cart!!!--------------");
        getCart(cart);
        System.out.println("Would you like to remove an item? (Yes / No)");
        scanner.nextLine();
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("yes")){
            System.out.println("Enter the product name to delete: ");
            String answer = scanner.nextLine();
            cart.removeIf(product -> product.getName().equalsIgnoreCase(answer));
        }
        else if(input.equalsIgnoreCase("no")){
            displayHomeInterface();
        }

    }

    //search by product name, price or department
    public void searchOption(){
        System.out.println("""
        -----------------Welcome to Search!!!----------------
        ( 1 ) Search by name?
        ( 2 ) Search by Price?
        ( 3 ) Search by Department
        Please enter from 1-3:""");
        switch (validateInput()) {
            case 1:
                System.out.print("Enter the name of the product: ");
                String productName = scanner.nextLine().trim();
                for (Product product: getProduct()){
                    if(product.getName().equalsIgnoreCase(productName)){
                        System.out.printf("\nYour result: %s",product.getName());
                    }
                }
                addProduct();
                System.out.print("\nReturning to Products Screen...\n\n");
                displayInventory();
                break;
            case 2:
                System.out.print("Enter the Max price to search: ");
                double productPrice = scanner.nextDouble();
                for (Product product: getProduct()){
                    if(product.getPrice() < productPrice){
                        System.out.printf("\nResult: %s, price: %.2f",product.getName(), product.getPrice());
                    }
                }
                addProduct();

                System.out.print("\nReturning to Products Screen...\n\n");
                displayInventory();
                break;
            case 3:
                System.out.print("Enter the department of the product: \n");
                scanner.nextLine();
                String productDepartment = scanner.nextLine().trim();
                for (Product product: getProduct()){
                    if(product.getDepartment().equalsIgnoreCase(productDepartment)){
                        System.out.printf("Result: %s, Department: %s\n",product.getName(), product.getDepartment());
                    }
                }
                addProduct();

                break;
            default:
                System.out.println("How did we get here...");
                break;
        }
    }

    //add a Product to the Screen
    public void addProduct(){
        //ask if the user wants to add products
        System.out.println("\nWould you like to add a product to the screen? (Yes / No)");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            System.out.println("Enter the product NAME you would like to add?");
            String name = scanner.nextLine();
            for (Product product: getProduct()){
                if(product.getName().equalsIgnoreCase(name)){
                    cart.add(product);
                    for(Product showCart : cart){
                        System.out.printf("Name: %s|Price: %.2f|Department: %s\n",
                                showCart.getName(), showCart.getPrice(), showCart.getDepartment());
                    }
                }
            }
        }
        else if (answer.equalsIgnoreCase("no")) {
            displayInventory();
        }
        else {
            System.out.println("Don't quite understand...\n");
            addProduct();
        }
    }

    //read product from file and make a method to call it
    public static ArrayList<Product> getProduct(){
        //make array list to contain the values
        ArrayList<Product> products = new ArrayList<>();

        //use try-with to open and close automatically
        String filePath = "src/main/resources/products.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {

                //deserialize
                String[] data = line.split("\\|");
                String sku = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2].replace(",",""));
                String department = data[3];

                //add data to the Product constructor
                Product product = new Product(sku, name, price, department);
                //add product to ArrayList products
                products.add(product);
            }
        }
        catch(IOException ex){
            System.out.println("Sorry couldn't read the file.");
        }
        return products;
    }

    public static void getCart(ArrayList<Product> cart){

        for(Product inCart : cart){
            System.out.printf("Name: %s|Price: %.2f|Department: %s\n",
                    inCart.getName(), inCart.getPrice(), inCart.getDepartment());
        }
    }
    //input validation
    public int validateInput(){
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                number = scanner.nextInt();
                while (number > 3 || number < 1){
                    System.out.println("Number not in between 1-3 >:(");
                    number = scanner.nextInt();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        System.out.println("You entered: " + number);
        return number;
    }
}
