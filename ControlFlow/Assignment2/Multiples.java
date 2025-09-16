import java.util.Scanner;

public class Multiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.print("Enter the limit: ");
        int limit = sc.nextInt();

        if (num <= 0 || limit <= 0) {
            System.out.println("Both should be positive numbers.");
        } else {
            System.out.println("Multiples of " + num + " up to " + limit + ":");
            for (int i = num; i <= limit; i += num) {
                System.out.println(i);
            }
        }
    }
}
