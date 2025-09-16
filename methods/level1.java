import java.util.Scanner;

public class level1 {

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return principal * rate * time / 100;
    }

    public static int maxHandshakes(int n) {
        return n * (n - 1) / 2;
    }

    public static int roundsToComplete5km(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(5000 / perimeter);
    }

    public static int checkNumberSign(int num) {
        if (num > 0) return 1;
        else if (num < 0) return -1;
        else return 0;
    }

    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        return new int[]{smallest, largest};
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static int[] divideChocolates(int chocolates, int children) {
        return findRemainderAndQuotient(chocolates, children);
    }

    public static double calculateWindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal, rate, time: ");
        double p = sc.nextDouble();
        double r = sc.nextDouble();
        double t = sc.nextDouble();
        System.out.println("Simple Interest is " + calculateSimpleInterest(p, r, t) +
                " for Principal " + p + ", Rate " + r + " and Time " + t);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        System.out.println("Maximum number of handshakes: " + maxHandshakes(n));

        System.out.print("Enter three sides of triangle (meters): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        System.out.println("Rounds to complete 5km: " + roundsToComplete5km(a, b, c));

        System.out.print("Enter a number to check sign: ");
        int num = sc.nextInt();
        int sign = checkNumberSign(num);
        System.out.println("Number sign: " + (sign == 1 ? "Positive" : sign == -1 ? "Negative" : "Zero"));

        System.out.print("Enter month and day: ");
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println(isSpringSeason(month, day) ? "It's a Spring Season" : "Not a Spring Season");

        System.out.print("Enter n for sum of natural numbers: ");
        int nSum = sc.nextInt();
        System.out.println("Sum of first " + nSum + " natural numbers: " + sumOfNaturalNumbers(nSum));

        System.out.print("Enter three numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[] minMax = findSmallestAndLargest(x, y, z);
        System.out.println("Smallest: " + minMax[0] + ", Largest: " + minMax[1]);

        System.out.print("Enter number and divisor: ");
        int num1 = sc.nextInt();
        int div = sc.nextInt();
        int[] qr = findRemainderAndQuotient(num1, div);
        System.out.println("Quotient: " + qr[0] + ", Remainder: " + qr[1]);

        System.out.print("Enter number of chocolates and children: ");
        int chocolates = sc.nextInt();
        int children = sc.nextInt();
        int[] chocoResult = divideChocolates(chocolates, children);
        System.out.println("Each child gets " + chocoResult[0] + ", Remaining chocolates: " + chocoResult[1]);

        System.out.print("Enter temperature and wind speed: ");
        double temp = sc.nextDouble();
        double wind = sc.nextDouble();
        System.out.printf("Wind Chill Temperature: %.2f\n", calculateWindChill(temp, wind));

        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        double[] trig = calculateTrigonometricFunctions(angle);
        System.out.printf("sin: %.4f, cos: %.4f, tan: %.4f\n", trig[0], trig[1], trig[2]);
    }
}
