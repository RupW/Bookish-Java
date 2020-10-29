package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Customers customers = new Customers();
        String userParameter = "";
        String searchRepeat = "";
        database.initialise();

        Scanner bookScanner = new Scanner(System.in);
        System.out.println("Search books? y/n");
        String bookInput = bookScanner.nextLine();
        if (bookInput.equalsIgnoreCase("y")) {
            // database search
            while (!searchRepeat.equalsIgnoreCase("n")) {
                Database.databaseSearch(database);
                Scanner repeat = new Scanner(System.in);
                System.out.println("Would you like to search again? y/n");
                searchRepeat = repeat.nextLine();
            }
        }
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Search customers? y/n");
        String userInput = userScanner.nextLine();
        if (bookInput.equalsIgnoreCase("y")) {
            // customer search
            while (!searchRepeat.equalsIgnoreCase("n")) {
                Customers.customerSearch(customers);
                Scanner repeat = new Scanner(System.in);
                System.out.println("Would you like to search again? y/n");
                searchRepeat = repeat.nextLine();
            }
        }
        database.cleanUp();
    }
}