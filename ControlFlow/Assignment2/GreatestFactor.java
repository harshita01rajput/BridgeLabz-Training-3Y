import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number <= 1) {
            System.out.println("No proper factors for " + number);
        } else {
            int greatest = 1;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    greatest = i;
                }
            }
            System.out.println("Greatest factor (excluding itself): " + greatest);
        }
    }
}
