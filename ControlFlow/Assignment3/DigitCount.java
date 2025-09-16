import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = 0;
        int temp = Math.abs(number); // handle negative numbers too

        // Loop until number becomes 0
        while (temp != 0) {
            temp = temp / 10; // remove last digit
            count++;          // increment counter
        }

        // Special case: when number = 0
        if (number == 0) {
            count = 1;
        }

        System.out.println("The number " + number + " has " + count + " digits.");
    }
}
