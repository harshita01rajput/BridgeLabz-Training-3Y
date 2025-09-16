public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        double ratePerDay;
        switch (carModel.toLowerCase()) {
            case "suv":
                ratePerDay = 70.0;
                break;
            case "sedan":
                ratePerDay = 50.0;
                break;
            case "luxury":
                ratePerDay = 100.0;
                break;
            default:
                ratePerDay = 40.0;
        }
        return ratePerDay * rentalDays;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("John Doe", "SUV", 5);

        rental1.displayRentalDetails();
        System.out.println();
        rental2.displayRentalDetails();
    }
}
