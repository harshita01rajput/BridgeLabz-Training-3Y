import java.util.ArrayList;
import java.util.List;

// Subject.java
class Subject {
    private String name;
    private double marks;

    public Subject(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}

// Student.java
class Student {
    private String name;
    private List<Subject> subjects; // Aggregation

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

// GradeCalculator.java
class GradeCalculator {
    public String calculateGrade(Student student) {
        if (student.getSubjects().isEmpty()) {
            return "No subjects to calculate grade.";
        }
        
        double totalMarks = 0;
        for (Subject subject : student.getSubjects()) {
            totalMarks += subject.getMarks();
        }
        
        double average = totalMarks / student.getSubjects().size();
        
        System.out.println(student.getName() + "'s average marks: " + average);
        
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

// Main class to run the application
public class level1 {
    public static void main(String[] args) {
        // Create a student and subjects
        Student john = new Student("John");
        john.addSubject(new Subject("Maths", 90));
        john.addSubject(new Subject("Science", 85));
        john.addSubject(new Subject("History", 78));

        // Create a grade calculator
        GradeCalculator calculator = new GradeCalculator();

        // Calculate and display the grade
        String grade = calculator.calculateGrade(john);
        System.out.println("Final Grade for " + john.getName() + ": " + grade);
    }
}
