import java.util.Scanner;

public class level3{

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitWords(String str) {
        int len = getLength(str), wordCount = 1;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') wordCount++;
        String[] words = new String[wordCount];
        int start = 0, index = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || str.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) word += str.charAt(j);
                words[index++] = word;
                start = i + 1;
            }
        }
        return words;
    }


    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }



    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";
        return new String[]{String.format("%.2f", weight), String.format("%.2f", heightCm),
                String.format("%.2f", bmi), status};
    }

    public static String[][] processBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) result[i] = calculateBMI(data[i][0], data[i][1]);
        return result;
    }

    public static void display2D(String[][] data, String[] headers) {
        for (String h : headers) System.out.printf("%-12s", h);
        System.out.println();
        for (String[] row : data) {
            for (String s : row) System.out.printf("%-12s", s);
            System.out.println();
        }
    }

    public static char[] uniqueCharacters(String str) {
        int len = getLength(str);
        char[] temp = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) if (str.charAt(j) == c) unique = false;
            if (unique) temp[index++] = c;
        }
        char[] result = new char[index];
        for (int i = 0; i < index; i++) result[i] = temp[i];
        return result;
    }

    public static char firstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = getLength(str);
        for (int i = 0; i < len; i++) freq[str.charAt(i)]++;
        for (int i = 0; i < len; i++) if (freq[str.charAt(i)] == 1) return str.charAt(i);
        return '\0';
    }

   
    public static String[][] charFrequencyASCII(String str) {
        int[] freq = new int[256];
        int len = getLength(str);
        for (int i = 0; i < len; i++) freq[str.charAt(i)]++;
        int count = 0;
        for (int f : freq) if (f > 0) count++;
        String[][] result = new String[count][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[idx][0] = Character.toString((char) i);
                result[idx++][1] = Integer.toString(freq[i]);
            }
        }
        return result;
    }

    
    public static String[][] charFrequencyNested(String str) {
        int len = getLength(str);
        char[] chars = new char[len];
        int[] freq = new int[len];
        for (int i = 0; i < len; i++) {
            chars[i] = str.charAt(i);
            freq[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] == '0') continue;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        int count = 0;
        for (char c : chars) if (c != '0') count++;
        String[][] result = new String[count][2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[idx][0] = Character.toString(chars[i]);
                result[idx++][1] = Integer.toString(freq[i]);
            }
        }
        return result;
    }

    public static boolean isPalindromeIterative(String str) {
        int start = 0, end = getLength(str) - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

   
    public static boolean isPalindromeReverse(String str) {
        int len = getLength(str);
        char[] original = new char[len];
        char[] reverse = new char[len];
        for (int i = 0; i < len; i++) {
            original[i] = str.charAt(i);
            reverse[len - 1 - i] = str.charAt(i);
        }
        for (int i = 0; i < len; i++) if (original[i] != reverse[i]) return false;
        return true;
    }



    public static boolean areAnagrams(String str1, String str2) {
        if (getLength(str1) != getLength(str2)) return false;
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < getLength(str1); i++) freq1[str1.charAt(i)]++;
        for (int i = 0; i < getLength(str2); i++) freq2[str2.charAt(i)]++;
        for (int i = 0; i < 256; i++) if (freq1[i] != freq2[i]) return false;
        return true;
    }

   

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void displayCalendar(int month, int year) {
        System.out.println("   " + getMonthName(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int firstDay = getFirstDayOfMonth(month, year);
        int days = getDaysInMonth(month, year);
        for (int i = 0; i < firstDay; i++) System.out.print("   ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%2d ", d);
            if ((d + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

 

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int idx = 0;
        for (String s : suits) for (String r : ranks) deck[idx++] = r + " of " + s;
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int players, int cards) {
        if (players * cards > deck.length) return null;
        String[][] hands = new String[players][cards];
        int idx = 0;
        for (int c = 0; c < cards; c++) {
            for (int p = 0; p < players; p++) {
                hands[p][c] = deck[idx++];
            }
        }
        return hands;
    }

    public static void displayHands(String[][] hands) {
        for (int p = 0; p < hands.length; p++) {
            System.out.print("Player " + (p + 1) + ": ");
            for (String card : hands[p]) System.out.print(card + ", ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        double[][] bmiData = new double[10][2];
        System.out.println("Enter weight(kg) and height(cm) for 10 people:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " weight: ");
            bmiData[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " height: ");
            bmiData[i][1] = sc.nextDouble();
        }
        display2D(processBMI(bmiData), new String[]{"Weight", "Height", "BMI", "Status"});

        sc.nextLine(); 

      
        System.out.print("Enter string for unique chars/frequency/palindrome/anagram: ");
        String text = sc.nextLine();

        System.out.print("Unique characters: ");
        for (char c : uniqueCharacters(text)) System.out.print(c + " ");
        System.out.println();

        char firstNon = firstNonRepeating(text);
        System.out.println("First non-repeating character: " + (firstNon != '\0' ? firstNon : "None"));

        System.out.println("Frequency (ASCII method):");
        display2D(charFrequencyASCII(text), new String[]{"Char", "Freq"});

        System.out.println("Frequency (Nested loops):");
        display2D(charFrequencyNested(text), new String[]{"Char", "Freq"});

        System.out.println("Palindrome check:");
        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " + isPalindromeRecursive(text, 0, getLength(text) - 1));
        System.out.println("Reverse array: " + isPalindromeReverse(text));

        System.out.print("Enter second string for anagram check: ");
        String text2 = sc.nextLine();
        System.out.println("Are anagrams? " + areAnagrams(text, text2));

      
        System.out.print("Enter month (1-12) and year for calendar: ");
        int month = sc.nextInt();
        int year = sc.nextInt();
        displayCalendar(month, year);

      
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        System.out.print("Enter number of players and cards per player: ");
        int players = sc.nextInt();
        int cards = sc.nextInt();
        String[][] hands = distributeCards(deck, players, cards);
        if (hands != null) displayHands(hands);
        else System.out.println("Cannot distribute cards, not enough in deck.");
    }
}
