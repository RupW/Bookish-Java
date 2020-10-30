package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Database;
import org.softwire.training.bookish.models.database.Rental;
import org.softwire.training.bookish.models.database.Users;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean searchRepeat = true;

    public static void main(String[] args) {
        Library library = new Library();
        Customers customers = new Customers();
        Rental rental = new Rental();

        Database.initialise();

        while (searchRepeat = true) {
            Scanner bookOrCustomer = new Scanner(System.in);
            System.out.println("Search books or customers? ... or exit");
            String userInput = bookOrCustomer.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                searchRepeat = false;
            }
            if (userInput.equalsIgnoreCase("customers")) {
                customers.customerSearch();
            }
            if (userInput.equalsIgnoreCase("books")) {
                Book bookResult = library.librarySearch();

                Scanner rentABook = new Scanner(System.in);
                System.out.println("Rent this book? y/n");
                String rentBook = rentABook.nextLine();

                if (rentBook.equalsIgnoreCase("n")) {
                    searchRepeat = false;
                }
                if (rentBook.equalsIgnoreCase("y")) {
                    Scanner userID = new Scanner(System.in);
                    System.out.println("Enter user ID: ");
                    String rentUser = userID.nextLine();
                    ArrayList<Users> user = customers.getUsersByID(rentUser);

                    library.takeFromStock(bookResult);
                    customers.addStockToUser(user.get(0));
                    rental.createRental(bookResult, user.get(0));
                    System.out.println("Rental confirmed.");
                }
                Scanner userResult = new Scanner(System.in);
                System.out.println("Would you like to search again? y/n");
                String searchAgain = userResult.nextLine();
                if (searchAgain.equalsIgnoreCase("n")) {
                    searchRepeat = false;
                }
            }
        }
        Database.cleanUp();
    }
}