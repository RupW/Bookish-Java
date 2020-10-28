package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "bookish_schema";
        String user = "root";
        String password = "";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        jdbcMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        ArrayList<String> bookTitle = new ArrayList<String>();
        Connection connection = DriverManager.getConnection(connectionString);

        String titleQuery = "select title from book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(titleQuery);
            while (rs.next()) {
                String title = rs.getString("title");
                bookTitle.add(title);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

        Collections.sort(bookTitle);
        System.out.println(bookTitle);
    }
}
