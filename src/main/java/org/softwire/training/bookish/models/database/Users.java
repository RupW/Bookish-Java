package org.softwire.training.bookish.models.database;

public class Users {
    private int id;
    private String fname;
    private String lname;
    private int no_of_books;

    public Users(int id, String fname, String lname, int no_of_books) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.no_of_books = no_of_books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getNo_of_books() {
        return no_of_books;
    }

    public void setNo_of_books(int no_of_books) {
        this.no_of_books = no_of_books;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", no_of_books=" + no_of_books +
                '}';
    }
}
