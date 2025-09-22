import java.util.ArrayList;
import java.util.List;

// Interface for insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Encapsulated sensitive field
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Encapsulation (no direct access to insurance policy number)
    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));

        if (this instanceof Insurable) {
            Insurable ins = (Insurable) this;
            System.out.println(ins.getInsuranceDetails());
            System.out.println("Insurance Cost: " + ins.calculateInsurance());
        }
        System.out.println("---------------------------------");
    }
}

// Car Class
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of daily rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy: " + getInsurancePolicyNumber() + ")";
    }
}

// Bike Class
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // Bikes cheaper, 20% discount
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of daily rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (Policy: " + getInsurancePolicyNumber() + ")";
    }
}

// Truck Class
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getRentalRate() * days;
        return days > 5 ? baseCost * 0.9 : baseCost; // 10% discount if rented >5 days
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of daily rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (Policy: " + getInsurancePolicyNumber() + ")";
    }
}

// Main Class
public class vehicleRental {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Car("CAR123", 2000, "POL1001");
        Vehicle bike = new Bike("BIKE456", 800, "POL2002");
        Vehicle truck = new Truck("TRUCK789", 5000, "POL3003");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        int rentalDays = 7;

        // Polymorphism in action
        for (Vehicle v : vehicles) {
            v.displayDetails(rentalDays);
        }
    }
}
