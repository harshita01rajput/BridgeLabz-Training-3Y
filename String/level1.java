import java.util.*;


class CompareStrings {
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}

class SubStringTask {
    public static String getSubstringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }
}


class CharArrayTask {
    public static char[] getChars(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }
}


class NullPointerDemo {
    public static void generate() {
        String text = null;
        System.out.println(text.length()); 
    }
    public static void handle() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException!");
        }
    }
}


class StringIndexDemo {
    public static void generate(String text) {
        System.out.println(text.charAt(text.length() + 1));
    }
    public static void handle(String text) {
        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException!");
        }
    }
}

class IllegalArgumentDemo {
    public static void generate(String text) {
        System.out.println(text.substring(5, 2)); 
    }
    public static void handle(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException!");
        }
    }
}


class NumberFormatDemo {
    public static void generate(String text) {
        System.out.println(Integer.parseInt(text));
    }
    public static void handle(String text) {
        try {
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException!");
        }
    }
}

class ArrayIndexDemo {
    public static void generate(String[] arr) {
        System.out.println(arr[arr.length + 1]);
    }
    public static void handle(String[] arr) {
        try {
            System.out.println(arr[arr.length + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException!");
        }
    }
}


class UppercaseTask {
    public static String toUpperCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
}
class LowercaseTask {
    public static String toLowerCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
}

public class level1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter two strings to compare:");
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println("CharAt Compare: " + CompareStrings.compareUsingCharAt(s1, s2));
        System.out.println("Built-in Equals: " + s1.equals(s2));

        System.out.println("\nEnter text:");
        String text = sc.next();
        System.out.println("Manual Uppercase: " + UppercaseTask.toUpperCaseManual(text));
        System.out.println("Built-in Uppercase: " + text.toUpperCase());

        
        NullPointerDemo.handle();

        sc.close();
    }
}
