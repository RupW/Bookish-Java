package org.softwire.training.bookish.models.database;

public class Book {
    private int id = this.id;
    private String title = this.title;
    private String author = this.author;
    private String genre = this.genre;
    private int year = this.year;
    private int no_in_stock = this.no_in_stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNo_in_stock() {
        return no_in_stock;
    }

    public void setNo_in_stock(int no_in_stock) {
        this.no_in_stock = no_in_stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", no_in_stock=" + no_in_stock +
                '}';
    }
}
