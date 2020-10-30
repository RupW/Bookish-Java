package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Database;
import org.softwire.training.bookish.models.database.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers {
    private Connection connection = null;

    public ArrayList<Users> getUsersByID(String userInput) {
        ArrayList<Users> userFound = new ArrayList<>();
        String IDQuery = "select * from users where id = '" + userInput + "'";

        connection = Database.getConnection();
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

        connection = Database.getConnection();
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

        connection = Database.getConnection();
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

        connection = Database.getConnection();
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
        System.out.println("Parameters to search by: (First Name/Last Name/ID/All)");
        String userParameter = parameterSearch.nextLine();

        if (userParameter.equalsIgnoreCase("First Name")) {
            Scanner fNameSearch = new Scanner(System.in);
            System.out.println("Enter first name: ");
            String userFName = fNameSearch.nextLine();
            result = getUsersByFName(userFName);
            user = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("Last Name")) {
            Scanner lNameSearch = new Scanner(System.in);
            System.out.println("Enter last name: ");
            String userLName = lNameSearch.nextLine();
            result = getUsersByLName(userLName);
            user = result.get(0);
        }
        if (userParameter.equalsIgnoreCase("ID")) {
            Scanner IDSearch = new Scanner(System.in);
            System.out.println("Enter ID: ");
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

    public void addStockToUser(Users user) {
        int userID = user.getId();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("update users set no_of_books=no_of_books+1 where id='" + userID + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
