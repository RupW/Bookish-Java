package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Database {
    private Connection connection = null;

    public void initialise() {
        String hostname = "localhost";
        String database = "bookish_schema";
        String user = "root";
        String password = "68Flinders!";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Book> getBooksByID(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String IDQuery = "select * from book where id = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(IDQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");

                Book book = new Book(id, title, author, genre, year, no_in_stock);
                bookFound.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public ArrayList<Book> getBooksByTitle(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String titleQuery = "select * from book where title = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(titleQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");
                Book book = new Book(id, title, author, genre, year, no_in_stock);
                bookFound.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public ArrayList<Book> getBooksByAuthor(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String authorQuery = "select * from book where author = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(authorQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");

                Book book = new Book(id, title, author, genre, year, no_in_stock);
                bookFound.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public ArrayList<Book> getBooksByGenre(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String genreQuery = "select * from book where genre = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(genreQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");

                Book book = new Book(id, title, author, genre, year, no_in_stock);
                bookFound.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> bookFound = new ArrayList<>();
        String allQuery = "select * from book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(allQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");

                Book book = new Book(id, title, author, genre, year, no_in_stock);
                bookFound.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public Book databaseSearch() {
        ArrayList<Book> result = null;
        Book book = null;

        Scanner parameterSearch = new Scanner(System.in);
        System.out.println("Parameters to search by: (Author/Title/Genre/All)");
        String userParameter = parameterSearch.nextLine();

        if (userParameter.equalsIgnoreCase("id")) {
            Scanner IDSearch = new Scanner(System.in);
            System.out.println("ID: ");
            String userID = IDSearch.nextLine();
            result = getBooksByTitle(userID);
            book = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("title")) {
            Scanner titleSearch = new Scanner(System.in);
            System.out.println("Title of book: ");
            String userTitle = titleSearch.nextLine();
            result = getBooksByTitle(userTitle);
            book = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("author")) {
            Scanner authorSearch = new Scanner(System.in);
            System.out.println("Author name: ");
            String userAuthor = authorSearch.nextLine();
            result = getBooksByAuthor(userAuthor);
            book = result.get(0);
        }
//        if (userParameter.equalsIgnoreCase("genre")) {
//            Scanner genreSearch = new Scanner(System.in);
//            System.out.println("Genre: ");
//            String userGenre = genreSearch.nextLine();
//            result = getBooksByGenre(userGenre);
//            book = result.get(0);
//        }
        if (userParameter.equalsIgnoreCase("all")) {
            result = getAllBooks();
        }
        System.out.println(result);
        return book;
    }

    public void takeFromStock(Book book) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("update book set no_in_stock=no_in_stock-1 where id='" + book.getId() + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cleanUp() {
        // enter code here to terminate connection with the database
    }
}
