public class LibararyBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public LibararyBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (availability ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 15.99, true);
        book1.displayInfo();
        book1.borrowBook();
        book1.displayInfo();
        book1.borrowBook();
    }
}
