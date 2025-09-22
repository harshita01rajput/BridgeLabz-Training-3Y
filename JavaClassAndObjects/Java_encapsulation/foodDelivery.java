import java.util.ArrayList;
import java.util.List;

// Interface for discount
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation - getters only, restrict modifications
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + " | Price: " + price + " | Qty: " + quantity);
    }
}

// Subclass VegItem
class VegItem extends FoodItem implements Discountable {
    private double discountApplied = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discountApplied;
    }

    @Override
    public void applyDiscount(double percent) {
        discountApplied = (percent / 100) * (getPrice() * getQuantity());
    }

    @Override
    public String getDiscountDetails() {
        return "Veg item discount: " + discountApplied;
    }
}

// Subclass NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private double serviceCharge = 20.0; // flat charge per item
    private double discountApplied = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + serviceCharge) - discountApplied;
    }

    @Override
    public void applyDiscount(double percent) {
        discountApplied = (percent / 100) * (getPrice() * getQuantity() + serviceCharge);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg item discount: " + discountApplied;
    }
}

// Main class
public class foodDelivery {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        // Create food items
        VegItem paneer = new VegItem("Paneer Butter Masala", 200, 2);
        NonVegItem chicken = new NonVegItem("Chicken Biryani", 300, 1);

        // Add to order
        order.add(paneer);
        order.add(chicken);

        // Apply discounts
        paneer.applyDiscount(10);   // 10% off on veg
        chicken.applyDiscount(5);   // 5% off on non-veg

        // Process order using polymorphism
        System.out.println("\n--- Order Details ---");
        double totalBill = 0;
        for (FoodItem item : order) {
            item.getItemDetails();
            double cost = item.calculateTotalPrice();
            System.out.println("Total Price (after discount): " + cost);

            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            System.out.println("--------------------");
            totalBill += cost;
        }

        System.out.println("Final Bill Amount: " + totalBill);
    }
}
