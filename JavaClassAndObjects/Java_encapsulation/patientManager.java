import java.util.ArrayList;
import java.util.List;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;

    // Sensitive data (encapsulation)
    private String diagnosis;
    private List<String> medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Getters (only safe fields exposed)
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Encapsulation for sensitive data
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Abstract method for billing
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (diagnosis != null) {
            System.out.println("Diagnosis: " + diagnosis);
        }
    }

    // Implement MedicalRecord methods
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + name + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}

// InPatient subclass
class InPatient extends Patient {
    private double roomChargePerDay;
    private int days;
    private double treatmentCost;

    public InPatient(String patientId, String name, int age,
                     double roomChargePerDay, int days, double treatmentCost) {
        super(patientId, name, age);
        this.roomChargePerDay = roomChargePerDay;
        this.days = days;
        this.treatmentCost = treatmentCost;
    }

    @Override
    public double calculateBill() {
        return (roomChargePerDay * days) + treatmentCost;
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private double consultationFee;
    private double testCharges;

    public OutPatient(String patientId, String name, int age,
                      double consultationFee, double testCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.testCharges = testCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFee + testCharges;
    }
}

// Main driver
public class patientManager {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        // Create InPatient
        InPatient p1 = new InPatient("P001", "Alice", 30, 2000, 3, 5000);
        p1.setDiagnosis("Pneumonia");
        p1.addRecord("Admitted on 12th Sept");
        p1.addRecord("X-ray done");

        // Create OutPatient
        OutPatient p2 = new OutPatient("P002", "Bob", 45, 500, 1200);
        p2.setDiagnosis("Migraine");
        p2.addRecord("Consulted on 14th Sept");
        p2.addRecord("MRI Scan done");

        // Add to hospital system
        patients.add(p1);
        patients.add(p2);

        // Process patients using polymorphism
        System.out.println("\n--- Patient Billing ---");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            patient.viewRecords();
            System.out.println("----------------------");
        }
    }
}
