package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.ArrayList;


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

    public ArrayList<Book> getBooksByAuthor(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String authorQuery = "select * from book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(authorQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");
                if (author.equalsIgnoreCase(userInput)) {
                    Book book = new Book(id, title, author, genre, year, no_in_stock);
                    bookFound.add(book);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public ArrayList<Book> getBooksByTitle(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String titleQuery = "select * from book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(titleQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");

                if (title.equalsIgnoreCase(userInput)) {
                    Book book = new Book(id, title, author, genre, year, no_in_stock);
                    bookFound.add(book);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }

    public ArrayList<Book> getBooksByGenre(String userInput) {
        ArrayList<Book> bookFound = new ArrayList<>();
        String genreQuery = "select * from book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(genreQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                int no_in_stock = rs.getInt("no_in_stock");

                if (genre.equalsIgnoreCase(userInput)) {
                    Book book = new Book(id, title, author, genre, year, no_in_stock);
                    bookFound.add(book);
                }
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

    public void cleanUp() {
        // enter code here to terminate connection with the database
    }
}
