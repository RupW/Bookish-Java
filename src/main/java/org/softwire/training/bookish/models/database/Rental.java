package org.softwire.training.bookish.models.database;

import org.softwire.training.bookish.Customers;
import org.softwire.training.bookish.Database;

public class Rental {
    public void rentABookFrom(Book book, Database database) {
        database.takeFromStock(book);
    }
    public void loanBookTo(Users user, Customers customers) {
        customers.addStockToUser(user);
    }
}
