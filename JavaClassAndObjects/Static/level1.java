package com.bridgelabz.oops.leveltwo;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}

class Book {
    String title, author;
    double price;
    boolean availability;

    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.availability = true;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + availability);
    }
}

class Circle {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public void displayCircle() {
        System.out.println("Circle Radius: " + radius);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    public void displayPerson() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class HotelBooking {
    String guestName, roomType;
    int nights;

    HotelBooking() {
        this("Unknown", "Standard", 1);
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    public void displayBooking() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }
}

class CarRental {
    String customerName, carModel;
    int rentalDays;
    static final int COST_PER_DAY = 1000;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public int calculateTotalCost() {
        return rentalDays * COST_PER_DAY;
    }

    public void displayRental() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays + ", Cost: " + calculateTotalCost());
    }
}

class Student {
    private static String universityName;
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void setUniversityName(String name) {
        universityName = name;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        System.out.println("University Name: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }

    public void updateGrade(char newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated to: " + newGrade);
    }
}

class Vehicle {
    private static double registrationFee = 100.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0.0) {
            registrationFee = newFee;
        }
    }

    public void displayRegistrationDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);
    }
}

class Patient {
    private static String hospitalName;
    private static int totalPatients = 0;
    private final String patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails() {
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

public class level1 {
    public static void main(String[] args) {
        // Employee
        Employee emp = new Employee("Rohan", 1, 500000);
        emp.displayEmployee();

        // Book
        Book book = new Book("Ramayan", "Valmiki", 500.0);
        book.displayBook();
        book.borrowBook();
        book.displayBook();

        // Circle
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.5);
        c1.displayCircle();
        c2.displayCircle();

        // Person
        Person p1 = new Person("Arjun", 25);
        Person p2 = new Person(p1);
        p1.displayPerson();
        p2.displayPerson();

        // HotelBooking
        HotelBooking hb1 = new HotelBooking("Sita", "Deluxe", 3);
        HotelBooking hb2 = new HotelBooking(hb1);
        hb1.displayBooking();
        hb2.displayBooking();

        // CarRental
        CarRental cr = new CarRental("Ravi", "SUV", 5);
        cr.displayRental();

        // Student
        Student.setUniversityName("Global University");
        Student s1 = new Student("Hemashree", 101, 'A');
        Student s2 = new Student("Sharmila", 102, 'B');
        Student.displayTotalStudents();
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        s2.updateGrade('A');
        s2.displayStudentDetails();

        // Vehicle
        Vehicle.updateRegistrationFee(150.0);
        Vehicle v1 = new Vehicle("Honest Raj", "Sedan", "ABC123");
        v1.displayRegistrationDetails();

        // Patient
        Patient.setHospitalName("City Hospital");
        Patient pat1 = new Patient("Lathika", 30, "Flu", "P001");
        Patient pat2 = new Patient("Lidiya", 45, "Fracture", "P002");
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
        pat1.displayPatientDetails();
        pat2.displayPatientDetails();
    }
}
