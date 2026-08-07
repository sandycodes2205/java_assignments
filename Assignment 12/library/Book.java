package library;

public class Book {
    int bookId = 101;
    String title = "Java Programming";
    String author = "James Gosling";
    double price = 450;

    public void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);    
    }
}
