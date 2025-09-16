import java.util.*;

public class level2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1. BONUS CALCULATION FOR 10 EMPLOYEES ---
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for emp " + (i+1) + ": ");
            salary[i] = sc.nextDouble();
            System.out.print("Enter years of service: ");
            years[i] = sc.nextDouble();
            if (salary[i] < 0 || years[i] < 0) { i--; continue; }
        }
        for (int i = 0; i < 10; i++) {
            bonus[i] = (years[i] > 5) ? salary[i] * 0.05 : salary[i] * 0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOld += salary[i];
            totalNew += newSalary[i];
        }
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOld);
        System.out.println("Total New Salary = " + totalNew);

        // --- 2. YOUNGEST & TALLEST ---
        int[] age = new int[3];
        int[] height = new int[3];
        String[] names = {"Amar","Akbar","Anthony"};
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = sc.nextInt();
        }
        int minAgeIndex = 0, maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[minAgeIndex]) minAgeIndex = i;
            if (height[i] > height[maxHeightIndex]) maxHeightIndex = i;
        }
        System.out.println("Youngest: " + names[minAgeIndex]);
        System.out.println("Tallest: " + names[maxHeightIndex]);

        // --- 3. LARGEST & SECOND LARGEST DIGIT ---
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] digits = new int[10];
        int idx = 0, maxDigit = 10;
        while (num != 0) {
            if (idx == maxDigit) break;
            digits[idx++] = num % 10;
            num /= 10;
        }
        int largest = 0, second = 0;
        for (int i = 0; i < idx; i++) {
            if (digits[i] > largest) {
                second = largest;
                largest = digits[i];
            } else if (digits[i] > second && digits[i] != largest) {
                second = digits[i];
            }
        }
        System.out.println("Largest: " + largest + ", Second Largest: " + second);

        // --- 4. DYNAMIC ARRAY VERSION (growable) ---
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        maxDigit = 10; idx = 0;
        int[] arr = new int[maxDigit];
        while (num != 0) {
            if (idx == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(arr, 0, temp, 0, arr.length);
                arr = temp;
            }
            arr[idx++] = num % 10;
            num /= 10;
        }
        largest = 0; second = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] > second && arr[i] != largest) {
                second = arr[i];
            }
        }
        System.out.println("Largest: " + largest + ", Second Largest: " + second);

        // --- 5. REVERSE NUMBER ---
        System.out.print("Enter number: ");
        num = sc.nextInt();
        String str = Integer.toString(num);
        char[] rev = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            rev[i] = str.charAt(str.length()-1-i);
        }
        System.out.println("Reversed: " + new String(rev));

        // --- 6. BMI CALCULATION ---
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[] heightArr = new double[n], weightArr = new double[n], bmi = new double[n];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i+1) + ": ");
            weightArr[i] = sc.nextDouble();
            System.out.print("Enter height (m) of person " + (i+1) + ": ");
            heightArr[i] = sc.nextDouble();
            bmi[i] = weightArr[i] / (heightArr[i] * heightArr[i]);
            if (bmi[i] < 18.5) status[i] = "Underweight";
            else if (bmi[i] < 25) status[i] = "Normal";
            else if (bmi[i] < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        for (int i = 0; i < n; i++) {
            System.out.println("H:" + heightArr[i] + " W:" + weightArr[i] + " BMI:" + bmi[i] + " Status:" + status[i]);
        }

        // --- 7. BMI WITH 2D ARRAY ---
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight(kg): ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height(m): ");
            personData[i][1] = sc.nextDouble();
            personData[i][2] = personData[i][0] / (personData[i][1]*personData[i][1]);
            if (personData[i][2] < 18.5) weightStatus[i] = "Underweight";
            else if (personData[i][2] < 25) weightStatus[i] = "Normal";
            else if (personData[i][2] < 30) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }
        for (int i = 0; i < n; i++) {
            System.out.println("H:" + personData[i][1] + " W:" + personData[i][0] + " BMI:" + personData[i][2] + " Status:" + weightStatus[i]);
        }

        // --- 8. MARKS & GRADES ---
        System.out.print("Enter number of students: ");
        int s = sc.nextInt();
        int[][] marks = new int[s][3];
        double[] perc = new double[s];
        char[] grade = new char[s];
        for (int i = 0; i < s; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter marks for subject " + (j+1) + ": ");
                marks[i][j] = sc.nextInt();
                sum += marks[i][j];
            }
            perc[i] = sum/3.0;
            if (perc[i] >= 90) grade[i] = 'A';
            else if (perc[i] >= 75) grade[i] = 'B';
            else if (perc[i] >= 50) grade[i] = 'C';
            else grade[i] = 'F';
        }
        for (int i = 0; i < s; i++) {
            System.out.println("P:" + marks[i][0] + " C:" + marks[i][1] + " M:" + marks[i][2] + " %:" + perc[i] + " Grade:" + grade[i]);
        }

        // --- 9. FREQUENCY OF DIGITS ---
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        int[] freq = new int[10];
        while (num != 0) {
            freq[num%10]++;
            num/=10;
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) System.out.println("Digit " + i + ": " + freq[i] + " times");
        }

        sc.close();
    }
}
