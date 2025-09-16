import java.util.Scanner;

public class LeapYearIfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("The year " + year + " is before the Gregorian calendar (1582). Not valid for Leap Year check.");
        } else {
            if (year % 400 == 0) {
                System.out.println("The year " + year + " is a Leap Year.");
            } else if (year % 100 == 0) {
                System.out.println("The year " + year + " is NOT a Leap Year.");
            } else if (year % 4 == 0) {
                System.out.println("The year " + year + " is a Leap Year.");
            } else {
                System.out.println("The year " + year + " is NOT a Leap Year.");
            }
        }
    }
}
