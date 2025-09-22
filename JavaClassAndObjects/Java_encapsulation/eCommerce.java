import java.util.ArrayList;
import java.util.List;

// Interface for Taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
    }

    // Encapsulation
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative.");
        }
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Polymorphic method to calculate final price
    public double getFinalPrice() {
        double discount = calculateDiscount();
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0;
        return price + tax - discount;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
        if (this instanceof Taxable) {
            System.out.println(((Taxable) this).getTaxDetails());
        }
        System.out.println("Final Price: " + getFinalPrice());
        System.out.println("---------------------------------");
    }
}

// Electronics Class
class Electronics extends Product implements Taxable {
    private double warrantyFee;

    public Electronics(int productId, String name, double price, double warrantyFee) {
        super(productId, name, price);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax (18% GST): " + calculateTax();
    }
}

// Clothing Class
class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax (5% GST): " + calculateTax();
    }
}

// Groceries Class
class Groceries extends Product {
    private double weightInKg;

    public Groceries(int productId, String name, double price, double weightInKg) {
        super(productId, name, price);
        this.weightInKg = weightInKg;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main Class
public class eCommerce {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product laptop = new Electronics(101, "Laptop", 50000, 2000);
        Product tshirt = new Clothing(102, "T-Shirt", 1500, "L");
        Product rice = new Groceries(103, "Rice", 2000, 5);

        products.add(laptop);
        products.add(tshirt);
        products.add(rice);

        // Polymorphism in action
        for (Product p : products) {
            p.displayDetails();
        }
    }
}
