import java.util.ArrayList;
import java.util.List;

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower; // sensitive borrower data (encapsulation)

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null; // initially available
    }

    // Encapsulation: borrower access restricted
    public String getBorrower() {
        return borrower;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId + " | Title: " + title + " | Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Status: " + (borrower == null ? "Available" : "Borrowed by " + borrower));
    }
}

// Subclass Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println(getTitle() + " reserved successfully by " + borrowerName);
        } else {
            System.out.println(getTitle() + " is already borrowed.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// Subclass Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println(getTitle() + " reserved successfully by " + borrowerName);
        } else {
            System.out.println(getTitle() + " is already borrowed.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// Subclass DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println(getTitle() + " reserved successfully by " + borrowerName);
        } else {
            System.out.println(getTitle() + " is already borrowed.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// Main Class
public class LibraryManagement {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        // Adding items
        items.add(new Book("B001", "The Alchemist", "Paulo Coelho"));
        items.add(new Magazine("M001", "National Geographic", "NatGeo Editors"));
        items.add(new DVD("D001", "Inception", "Christopher Nolan"));

        // Polymorphic handling
        System.out.println("\n--- Library Items ---");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("---------------------");
        }

        // Reservation demo
        System.out.println("\n--- Reservation Demo ---");
        if (items.get(0) instanceof Reservable) {
            Reservable book = (Reservable) items.get(0);
            book.reserveItem("Alice");
            book.reserveItem("Bob"); // should fail
        }

        if (items.get(2) instanceof Reservable) {
            Reservable dvd = (Reservable) items.get(2);
            dvd.reserveItem("Charlie");
        }

        // Display updated details
        System.out.println("\n--- Updated Library Items ---");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("---------------------");
        }
    }
}
