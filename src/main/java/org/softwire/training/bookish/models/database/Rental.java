package org.softwire.training.bookish.models.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Rental {
    private static Connection connection = null;

    public void createRental(Book book, Users users) {
        connection = Database.getConnection();

        LocalDate currentDate = LocalDate.now();
        LocalDate returnDate = currentDate.plusDays(14);
        String localDate = currentDate.toString();
        String localReturnDate = returnDate.toString();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("insert into rental(user_ID,book_ID,date_out,date_in)values('" + users.getId() + "','" + book.getId() + "','" + localDate + "','" + localReturnDate + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}