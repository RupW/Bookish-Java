package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers {
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
    public ArrayList<Users> getUsersByID(String userInput) {
        ArrayList<Users> userFound = new ArrayList<>();
        String IDQuery = "select * from users where id = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(IDQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                int no_of_books = rs.getInt("no_of_books");

                Users user = new Users(id, fname, lname, no_of_books);
                userFound.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }

    public ArrayList<Users> getUsersByFName(String userInput) {
        ArrayList<Users> userFound = new ArrayList<>();
        String fNameQuery = "select * from users where fname = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(fNameQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                int no_of_books = rs.getInt("no_of_books");

                Users user = new Users(id, fname, lname, no_of_books);
                userFound.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }
    public ArrayList<Users> getUsersByLName(String userInput) {
        ArrayList<Users> userFound = new ArrayList<>();
        String lNameQuery = "select * from users where fname = '" + userInput + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(lNameQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                int no_of_books = rs.getInt("no_of_books");

                Users user = new Users(id, fname, lname, no_of_books);
                userFound.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }

    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> userFound = new ArrayList<>();
        String allQuery = "select * from users";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(allQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                int no_of_books = rs.getInt("no_of_books");

                Users user = new Users(id, fname, lname, no_of_books);
                userFound.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }

    public Users customerSearch() {
        ArrayList<Users> result = null;
        Users user = null;

        Scanner parameterSearch = new Scanner(System.in);
        System.out.println("Parameters to search by: (First Name/Last Name/ID)");
        String userParameter = parameterSearch.nextLine();

        if (userParameter.equalsIgnoreCase("First Name")) {
            Scanner fNameSearch = new Scanner(System.in);
            System.out.println("First Name");
            String userFName = fNameSearch.nextLine();
            result = getUsersByFName(userFName);
            user = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("Last Name")) {
            Scanner lNameSearch = new Scanner(System.in);
            System.out.println("Last Name: ");
            String userLName = lNameSearch.nextLine();
            result = getUsersByLName(userLName);
            user = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("ID")) {
            Scanner IDSearch = new Scanner(System.in);
            System.out.println("ID: ");
            String userID = IDSearch.nextLine();
            result = getUsersByID(userID);
            user = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("All")) {
            result = getAllUsers();
        }
        System.out.println(result);
        return user;
    }

    public void addStockToUser (Users user) {
        String allQuery = "update users set no_of_books=no_of_books-1 where id='" + user.getId() + "'";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(allQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //sql command to update table
    }

    public void cleanUp() {
        // enter code here to terminate connection with the database
    }
}
