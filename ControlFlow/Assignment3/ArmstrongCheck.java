import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int originalNumber = number;
        int sum = 0;

        // Loop until originalNumber reduces to 0
        while (originalNumber != 0) {
            int digit = originalNumber % 10;   // extract last digit
            sum += digit * digit * digit;      // cube the digit and add to sum
            originalNumber = originalNumber / 10; // remove last digit
        }

        if (sum == number) {
            System.out.println("The number " + number + " is an Armstrong Number.");
        } else {
            System.out.println("The number " + number + " is NOT an Armstrong Number.");
        }
    }
}
