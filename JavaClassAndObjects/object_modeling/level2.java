import java.util.ArrayList;
import java.util.List;

// Product.java
class Product {
    private String name;
    private double unitPrice;
    private double quantity;

    public Product(String name, double unitPrice, double quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }
}

// Customer.java
class Customer {
    private String name;
    private List<Product> purchasedProducts; // Composition

    public Customer(String name) {
        this.name = name;
        this.purchasedProducts = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        this.purchasedProducts.add(product);
        System.out.println(this.name + " purchased " + product.getQuantity() + "kg of " + product.getName() + ".");
    }

    public String getName() {
        return name;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
}

// BillGenerator.java
class BillGenerator {
    // Method to calculate the total bill for a customer
    public double generateBill(Customer customer) {
        System.out.println("\nGenerating bill for " + customer.getName() + "...");
        double total = 0.0;
        
        
        for (Product product : customer.getPurchasedProducts()) {
            double productTotal = product.getUnitPrice() * product.getQuantity();
            total += productTotal;
            System.out.println("  " + product.getName() + " (" + product.getQuantity() + "kg) @ $" + product.getUnitPrice() + "/kg = $" + String.format("%.2f", productTotal));
        }
        return total;
    }
}


public class level2{
    public static void main(String[] args) {
        // Create a new customer
        Customer alice = new Customer("Alice");

        
        alice.buyProduct(new Product("Apples", 3.0, 2.0));
        alice.buyProduct(new Product("Milk", 2.0, 1.0));
        alice.buyProduct(new Product("Bread", 2.5, 1.0));

    
        BillGenerator billGen = new BillGenerator();
        double finalBillAmount = billGen.generateBill(alice);

        // Display the final total
        System.out.println("-------------------------------------");
        System.out.println("Total bill amount: $" + String.format("%.2f", finalBillAmount));
    }
}
