import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayEmployee() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void areaCircle() {
        System.out.printf("Area of Circle: %.4f\n", Math.PI * radius * radius);
    }

    void circumferenceCircle() {
        System.out.printf("Circumference of Circle: %.4f\n", 2 * Math.PI * radius);
    }
}

class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBook() {
        System.out.println("\n");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : " + price);
    }
}

class Item {
    String code;
    String name;
    double price;

    Item(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    void displayItem(int qty) {
        System.out.println("items");
        System.out.println("Item Code : " + code);
        System.out.println("Item Name : " + name);
        System.out.println("Item Price: " + price);
        System.out.println("Total Cost for " + qty + " = " + (price * qty));
    }
}

class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayMobile() {
        System.out.println("\nMobile Details");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }
}

public class level1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n MENU");
            System.out.println("1. Employee Details");
            System.out.println("2. Circle Area & Circumference");
            System.out.println("3. Book Details");
            System.out.println("4. Inventory Items");
            System.out.println("5. Mobile Phone Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String ename = sc.nextLine();
                    System.out.print("Enter Employee ID: ");
                    int eid = sc.nextInt();
                    System.out.print("Enter Employee Salary: ");
                    double esal = sc.nextDouble();
                    Employee emp = new Employee(ename, eid, esal);
                    emp.displayEmployee();
                    break;

                case 2:
                    System.out.print("Enter radius of Circle: ");
                    double r = sc.nextDouble();
                    Circle circle = new Circle(r);
                    circle.areaCircle();
                    circle.circumferenceCircle();
                    break;

                case 3:
                    System.out.print("Enter Book Title: ");
                    String btitle = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bauthor = sc.nextLine();
                    System.out.print("Enter Book Price: ");
                    double bprice = sc.nextDouble();
                    Book book = new Book(btitle, bauthor, bprice);
                    book.displayBook();
                    break;

                case 4:
                    System.out.print("Enter Item Code: ");
                    String icode = sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String iname = sc.nextLine();
                    System.out.print("Enter Item Price: ");
                    double iprice = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    Item item = new Item(icode, iname, iprice);
                    item.displayItem(qty);
                    break;

                case 5:
                    System.out.print("Enter Mobile Brand: ");
                    String mbrand = sc.nextLine();
                    System.out.print("Enter Mobile Model: ");
                    String mmodel = sc.nextLine();
                    System.out.print("Enter Mobile Price: ");
                    double mprice = sc.nextDouble();
                    MobilePhone mob = new MobilePhone(mbrand, mmodel, mprice);
                    mob.displayMobile();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
}
