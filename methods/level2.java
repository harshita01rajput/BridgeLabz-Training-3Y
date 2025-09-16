import java.util.Scanner;

public class level2 {

    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) if (num % i == 0) count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) if (num % i == 0) factors[index++] = i;
        return factors;
    }

    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static int sumOfSquare(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += Math.pow(val, 2);
        return sum;
    }

    public static int productOfArray(int[] arr) {
        int prod = 1;
        for (int val : arr) prod *= val;
        return prod;
    }

    public static int sumRecursion(int n) {
        if (n == 1) return 1;
        return n + sumRecursion(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static boolean isLeapYear(int year) {
        return (year >= 1582) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    public static class UnitConvertor {
        public static double convertKmToMiles(double km) { return km * 0.621371; }
        public static double convertMilesToKm(double miles) { return miles * 1.60934; }
        public static double convertMetersToFeet(double m) { return m * 3.28084; }
        public static double convertFeetToMeters(double f) { return f * 0.3048; }
        public static double convertYardsToFeet(double y) { return y * 3; }
        public static double convertFeetToYards(double f) { return f * 0.333333; }
        public static double convertMetersToInches(double m) { return m * 39.3701; }
        public static double convertInchesToMeters(double i) { return i * 0.0254; }
        public static double convertInchesToCm(double i) { return i * 2.54; }
        public static double convertFahrenheitToCelsius(double f) { return (f - 32) * 5 / 9; }
        public static double convertCelsiusToFahrenheit(double c) { return (c * 9 / 5) + 32; }
        public static double convertPoundsToKg(double p) { return p * 0.453592; }
        public static double convertKgToPounds(double kg) { return kg * 2.20462; }
        public static double convertGallonsToLiters(double g) { return g * 3.78541; }
        public static double convertLitersToGallons(double l) { return l * 0.264172; }
    }

    public static class StudentVoteChecker {
        public boolean canStudentVote(int age) {
            if (age < 0) return false;
            return age >= 18;
        }
    }

    public static int findYoungestIndex(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) if (ages[i] < ages[minIndex]) minIndex = i;
        return minIndex;
    }

    public static int findTallestIndex(int[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) if (heights[i] > heights[maxIndex]) maxIndex = i;
        return maxIndex;
    }

    public static boolean isPositive(int n) { return n >= 0; }
    public static boolean isEven(int n) { return n % 2 == 0; }
    public static int compare(int a, int b) { return a > b ? 1 : (a == b ? 0 : -1); }

    public static double[][] computeBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightInMeters = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
        return data;
    }

    public static String[] bmiStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 25) status[i] = "Normal";
            else if (bmi < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        return status;
    }

    public static double[] quadraticRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) return new double[]{};
        if (delta == 0) return new double[]{-b / (2 * a)};
        return new double[]{(-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a)};
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = 1000 + (int) (Math.random() * 9000);
        return arr;
    }

    public static double[] findAverageMinMax(int[] arr) {
        double sum = 0;
        int min = arr[0], max = arr[0];
        for (int val : arr) {
            sum += val;
            if (val < min) min = val;
            if (val > max) max = val;
        }
        return new double[]{sum / arr.length, min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number to find factors: ");
        int num = sc.nextInt();
        int[] factors = findFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nSum: " + sumOfArray(factors) + ", Product: " + productOfArray(factors) + ", Sum of Squares: " + sumOfSquare(factors));

        System.out.print("Enter n for sum of natural numbers: ");
        int n = sc.nextInt();
        int sumRec = sumRecursion(n);
        int sumForm = sumFormula(n);
        System.out.println("Sum (Recursion): " + sumRec + ", Sum (Formula): " + sumForm);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        System.out.println(isLeapYear(year) ? "Leap Year" : "Not Leap Year");

        StudentVoteChecker svc = new StudentVoteChecker();
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.println("Can vote: " + svc.canStudentVote(ages[i]));
        }

        int[] friendAges = new int[3];
        int[] friendHeights = new int[3];
        String[] friends = {"Amar", "Akbar", "Anthony"};
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age and height of " + friends[i] + ": ");
            friendAges[i] = sc.nextInt();
            friendHeights[i] = sc.nextInt();
        }
        System.out.println("Youngest: " + friends[findYoungestIndex(friendAges)]);
        System.out.println("Tallest: " + friends[findTallestIndex(friendHeights)]);

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            if (isPositive(numbers[i])) {
                System.out.println(numbers[i] + " is Positive " + (isEven(numbers[i]) ? "Even" : "Odd"));
            } else System.out.println(numbers[i] + " is Negative");
        }
        int cmp = compare(numbers[0], numbers[4]);
        System.out.println("First vs Last comparison: " + (cmp == 1 ? "Greater" : cmp == 0 ? "Equal" : "Less"));

        double[][] bmiData = new double[10][3];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight(kg) and height(cm) for person " + (i + 1) + ": ");
            bmiData[i][0] = sc.nextDouble();
            bmiData[i][1] = sc.nextDouble();
        }
        computeBMI(bmiData);
        String[] bmiStatuses = bmiStatus(bmiData);
        for (int i = 0; i < 10; i++)
            System.out.println("Person " + (i + 1) + ": Weight=" + bmiData[i][0] + ", Height=" + bmiData[i][1] + ", BMI=" + bmiData[i][2] + ", Status=" + bmiStatuses[i]);

        System.out.print("Enter a, b, c for quadratic equation: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double[] roots = quadraticRoots(a, b, c);
        if (roots.length == 0) System.out.println("No real roots");
        else for (int i = 0; i < roots.length; i++) System.out.println("Root " + (i + 1) + ": " + roots[i]);

        int[] randomNumbers = generate4DigitRandomArray(5);
        double[] avgMinMax = findAverageMinMax(randomNumbers);
        System.out.print("Random numbers: ");
        for (int val : randomNumbers) System.out.print(val + " ");
        System.out.println("\nAverage: " + avgMinMax[0] + ", Min: " + avgMinMax[1] + ", Max: " + avgMinMax[2]);
    }
}
