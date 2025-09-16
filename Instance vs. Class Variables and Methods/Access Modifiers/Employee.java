class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    private String project;

    public Manager(int employeeID, String department, double salary, String project) {
        super(employeeID, department, salary);
        this.project = project;
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Project: " + project);
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(1001, "IT", 75000.0, "Migration Project");
        mgr.displayManagerDetails();
        System.out.println("Salary: $" + mgr.getSalary());
        mgr.setSalary(80000.0);
        System.out.println("Updated Salary: $" + mgr.getSalary());
    }
}
