import java.util.ArrayList;
import java.util.List;

// Interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Abstract Class
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Base salary must be positive.");
        }
    }

    // Abstract Method
    public abstract double calculateSalary();

    // Concrete Method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + (department == null ? "Not Assigned" : department));
        System.out.println("Calculated Salary: " + calculateSalary());
        System.out.println("---------------------------------");
    }

    // Department interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return department == null ? "No department assigned" : department;
    }
}

// FullTimeEmployee Subclass
class FullTimeEmployee extends Employee {
    private double fixedBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedBonus;
    }
}

// PartTimeEmployee Subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0); // baseSalary not used, calculated dynamically
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main Class
public class employees{
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000, 10000);
        emp1.assignDepartment("IT");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 500, 40);
        emp2.assignDepartment("Support");

        FullTimeEmployee emp3 = new FullTimeEmployee(103, "Charlie", 60000, 8000);
        emp3.assignDepartment("HR");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        // Polymorphism in action
        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}
