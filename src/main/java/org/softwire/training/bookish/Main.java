package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Rental;
import org.softwire.training.bookish.models.database.Users;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Customers customers = new Customers();
        Rental rental = new Rental();
        String searchRepeat = "";
        database.initialise();

        Scanner bookScanner = new Scanner(System.in);
        System.out.println("Search books or customers? ... or exit");
        String userInput = bookScanner.nextLine();

        while (!searchRepeat.equalsIgnoreCase("exit" || "no")) {
            if (userInput.equalsIgnoreCase("customers")) {
                while (!searchRepeat.equalsIgnoreCase("n")) {
                    customers.customerSearch();
                }
            }
            if (userInput.equalsIgnoreCase("books")) {

                // book database search
                Book bookResult = database.databaseSearch();

                Scanner rentABook = new Scanner(System.in);
                System.out.println("Rent this book? y/n");
                String rentBook = rentABook.nextLine();

                if (rentBook.equalsIgnoreCase("y")) {
                    Scanner userResult = new Scanner(System.in);
                    System.out.println("Enter user ID: ");
                    String rentUser = userResult.nextLine();

                    database.takeFromStock(bookResult);
                    customers.addStockToUser(customers.getUsersByID(rentUser));
                }
            }

            Scanner repeat = new Scanner(System.in);
            System.out.println("Would you like to search again?");
            searchRepeat = repeat.nextLine();
        }

        database.cleanUp();
    }
}