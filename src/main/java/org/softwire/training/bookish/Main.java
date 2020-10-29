package org.softwire.training.bookish;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Customers customers = new Customers();
        String searchRepeat = "";

        Scanner bookScanner = new Scanner(System.in);
        System.out.println("Search books? y/n");
        String bookInput = bookScanner.nextLine();
        if (bookInput.equalsIgnoreCase("y")) {
            // database search
            while (!searchRepeat.equalsIgnoreCase("n")) {
                database.initialise();
                Database.databaseSearch(database);
                Scanner repeat = new Scanner(System.in);
                System.out.println("Would you like to search again? y/n");
                searchRepeat = repeat.nextLine();
            }
        }
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Search customers? y/n");
        String userInput = userScanner.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            // customer search
            while (!searchRepeat.equalsIgnoreCase("n")) {
                customers.initialise();
                Customers.customerSearch(customers);
                Scanner repeat = new Scanner(System.in);
                System.out.println("Would you like to search again? y/n");
                searchRepeat = repeat.nextLine();
            }
        }
        database.cleanUp();
    }
}