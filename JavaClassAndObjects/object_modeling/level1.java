import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }
}

class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}

class Teacher {
    private String name;
    private String teacherId;

    public Teacher(String name, String teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }
}

class Course {
    private String courseName;
    private Teacher instructor;
    private List<Student> enrolledStudents;

    public Course(String courseName, Teacher instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " has been enrolled in " + courseName);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getInstructor() {
        return instructor;
    }
}

class School {
    private String schoolName;
    private List<Course> courses;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course " + course.getCourseName() + " has been added to " + schoolName);
    }

    public void showCourses() {
        System.out.println("Courses offered by " + schoolName + ":");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName() + " (Instructor: " + course.getInstructor().getName() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Bank account demo
        BankAccount johnsAccount = new BankAccount("123456789", "John Doe", 1000.00);
        BankAccount janesAccount = new BankAccount("987654321", "Jane Smith", 1500.00);

        johnsAccount.deposit(500);
        johnsAccount.withdraw(200);
        System.out.println("John's balance: " + johnsAccount.getBalance());

        janesAccount.withdraw(2000);
        janesAccount.deposit(300);
        janesAccount.displayAccountInfo();

        // School system demo
        Teacher teacher1 = new Teacher("Mr. Brown", "T001");
        Course mathCourse = new Course("Mathematics", teacher1);

        Student student1 = new Student("Alice", "S001");
        Student student2 = new Student("Bob", "S002");

        mathCourse.enrollStudent(student1);
        mathCourse.enrollStudent(student2);

        School school = new School("Greenwood High");
        school.addCourse(mathCourse);

        school.showCourses();
        mathCourse.showEnrolledStudents();
    }
}
