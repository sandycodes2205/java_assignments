class LibraryBook {

    final String isbn = "9789351234567";
    String title = "Java Programming";
    String author = "James Gosling";
    double price = 450;

    void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        LibraryBook book = new LibraryBook();
        book.display();

        // book.isbn = "1234567890"; // Not allowed 
    }
}