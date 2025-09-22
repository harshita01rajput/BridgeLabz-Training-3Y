import java.util.ArrayList;
import java.util.List;

// Interface for Loan functionality
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract Class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: controlled access
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }
}

// SavingsAccount Class
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4% annual
    private double loanAmount;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmount = amount;
        System.out.println(getHolderName() + " applied for a loan of: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        boolean eligible = getBalance() >= 2000;
        System.out.println(getHolderName() + " Loan Eligibility: " + (eligible ? "Approved" : "Rejected"));
        return eligible;
    }
}

// CurrentAccount Class
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2% annual
    private double loanAmount;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmount = amount;
        System.out.println(getHolderName() + " applied for a loan of: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        boolean eligible = getBalance() >= 5000;
        System.out.println(getHolderName() + " Loan Eligibility: " + (eligible ? "Approved" : "Rejected"));
        return eligible;
    }
}

// Main Class
public class bankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SAV001", "Alice", 3000);
        BankAccount acc2 = new CurrentAccount("CUR002", "Bob", 10000);

        accounts.add(acc1);
        accounts.add(acc2);

        // Transactions
        acc1.deposit(1000);
        acc2.withdraw(2000);

        System.out.println("\n--- Account Details ---");
        for (BankAccount acc : accounts) {
            acc.displayDetails();
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(5000);
                loanAcc.calculateLoanEligibility();
            }
            System.out.println("------------------------");
        }
    }
}
