import java.util.*;

public class level1 {

    // 1. Voting eligibility for 10 students
    static void votingEligibility() {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age");
            } else if (age >= 18) {
                System.out.println("Student with age " + age + " can vote.");
            } else {
                System.out.println("Student with age " + age + " cannot vote.");
            }
        }
    }

    // 2. Positive, negative, zero check for 5 numbers + compare first & last
    static void numberCheck() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        for (int n : nums) {
            if (n > 0) {
                if (n % 2 == 0) System.out.println(n + " is Positive Even");
                else System.out.println(n + " is Positive Odd");
            } else if (n < 0) {
                System.out.println(n + " is Negative");
            } else {
                System.out.println(n + " is Zero");
            }
        }
        if (nums[0] == nums[4]) System.out.println("First and last are equal.");
        else if (nums[0] > nums[4]) System.out.println("First is greater than last.");
        else System.out.println("First is less than last.");
    }

    // 3. Multiplication table of a number
    static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }

    // 4. Store numbers until 0/negative or max 10
    static void storeNumbers() {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double total = 0;
        int index = 0;
        while (true) {
            if (index == 10) break;
            System.out.print("Enter number: ");
            double num = sc.nextDouble();
            if (num <= 0) break;
            arr[index++] = num;
        }
        for (int i = 0; i < index; i++) {
            total += arr[i];
            System.out.println("Number " + (i + 1) + " = " + arr[i]);
        }
        System.out.println("Sum = " + total);
    }

    // 5. Multiplication tables of numbers 6 to 9
    static void tables6to9() {
        for (int num = 6; num <= 9; num++) {
            System.out.println("Table of " + num + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " * " + i + " = " + (num * i));
            }
            System.out.println();
        }
    }

    // 6. Mean height of football team (11 players)
    static void meanHeight() {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;
        System.out.println("Enter heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }
        double mean = sum / heights.length;
        System.out.println("Mean height = " + mean);
    }

    // 7. Odd and Even arrays
    static void oddEvenArrays() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Not a natural number.");
            return;
        }
        int[] odd = new int[num / 2 + 1];
        int[] even = new int[num / 2 + 1];
        int oi = 0, ei = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) even[ei++] = i;
            else odd[oi++] = i;
        }
        System.out.println("Odd numbers:");
        for (int i = 0; i < oi; i++) System.out.print(odd[i] + " ");
        System.out.println("\nEven numbers:");
        for (int i = 0; i < ei; i++) System.out.print(even[i] + " ");
        System.out.println();
    }

    // 8. Factors of a number
    static void factorsOfNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors.add(i);
        }
        System.out.println("Factors: " + factors);
    }

    // 9. Copy 2D array into 1D array
    static void copy2Dto1D() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }
        System.out.println("1D array: " + Arrays.toString(array));
    }

    // 10. FizzBuzz
    static void fizzBuzz() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Not a positive integer.");
            return;
        }
        String[] results = new String[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) results[i] = "FizzBuzz";
            else if (i % 3 == 0) results[i] = "Fizz";
            else if (i % 5 == 0) results[i] = "Buzz";
            else results[i] = String.valueOf(i);
        }
        for (int i = 1; i <= num; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
    }

    // Main Method - calls all programs
    public static void main(String[] args) {
        // Call each method one by one
        // Uncomment the one you want to test

        votingEligibility();
        numberCheck();
        multiplicationTable();
        storeNumbers();
        tables6to9();
        meanHeight();
        oddEvenArrays();
        factorsOfNumber();
        copy2Dto1D();
        fizzBuzz();
    }
}
