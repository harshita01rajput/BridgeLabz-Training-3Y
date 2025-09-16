import java.util.Scanner;

// 1. Student Report
class StudentsGrades {
    String name;
    String rollNumber;
    double[] marks;

    StudentsGrades(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 80) return "Grade A";
        else if (avg >= 60) return "Grade B";
        else if (avg >= 50) return "Grade C";
        else if (avg >= 40) return "Grade D";
        else return "Grade F";
    }

    private double calculateAverage() {
        double sum = 0;
        for (double m : marks) sum += m;
        return sum / marks.length;
    }

    public void displayStudent() {
        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNumber);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Result: " + calculateGrade());
    }
}

// 2. BankAccount (ATM Simulation)
class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// 3. Palindrome Checker
class PalindromeChecker {
    private String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String clean = text.replaceAll("\\s", "").toLowerCase();
        String reverse = new StringBuilder(clean).reverse().toString();
        return clean.equals(reverse);
    }

    public void displayResult() {
        System.out.println(text + (isPalindrome() ? " is Palindrome" : " is NOT Palindrome"));
    }
}

// 4. Movie Ticket Booking
class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
        this.isBooked = false;
    }

    public void bookTicket(String seat, double price) {
        if (isBooked) {
            System.out.println("❌ Ticket already booked!");
        } else {
            this.seatNumber = seat;
            this.price = price;
            this.isBooked = true;
            System.out.println("✅ Ticket booked successfully!");
        }
    }

    public void displayTicket() {
        if (isBooked) {
            System.out.println("\n--- Ticket Details ---");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat : " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println("No ticket booked yet.");
        }
    }
}

// 5. Shopping Cart
class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    CartItem(String itemName, double price, int qty) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = qty;
    }

    public void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " " + itemName + "(s).");
    }

    public void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " " + itemName + "(s).");
        } else {
            System.out.println("Not enough quantity to remove.");
        }
    }

    public void displayItem() {
        System.out.println(itemName + " | Price: " + price + " | Qty: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }
}

// Main Menu
public class level2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LEVEL 2 MENU =====");
            System.out.println("1. Student Report");
            System.out.println("2. ATM Simulation");
            System.out.println("3. Palindrome Checker");
            System.out.println("4. Movie Ticket Booking");
            System.out.println("5. Shopping Cart");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    double[] marks = {75, 85, 90};
                    StudentsGrades s1 = new StudentsGrades("Ramesh", "CSE101", marks);
                    s1.displayStudent();
                    break;

                case 2:
                    BankAccount acc = new BankAccount("Sita", "12345", 1000);
                    acc.displayBalance();
                    acc.deposit(500);
                    acc.withdraw(300);
                    acc.displayBalance();
                    break;

                case 3:
                    System.out.print("Enter text to check palindrome: ");
                    String text = sc.nextLine();
                    PalindromeChecker pc = new PalindromeChecker(text);
                    pc.displayResult();
                    break;

                case 4:
                    MovieTicket mt = new MovieTicket("RRR");
                    mt.displayTicket();
                    mt.bookTicket("A10", 250);
                    mt.displayTicket();
                    break;

                case 5:
                    CartItem item = new CartItem("Laptop", 50000, 1);
                    item.displayItem();
                    item.addItem(2);
                    item.removeItem(1);
                    item.displayItem();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
