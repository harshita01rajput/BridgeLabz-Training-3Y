import java.util.Scanner;

public class level2 {

    
    public static int getStringLength(String str) {
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

    public static String[] splitIntoWords(String str) {
        int wordCount = 1; // at least 1 word
        for (int i = 0; i < getStringLength(str); i++) {
            if (str.charAt(i) == ' ') wordCount++;
        }

        String[] words = new String[wordCount];
        int start = 0, w = 0;
        for (int i = 0; i <= getStringLength(str); i++) {
            if (i == getStringLength(str) || str.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) {
                    word += str.charAt(j);
                }
                words[w++] = word;
                start = i + 1;
            }
        }
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }

    public static String[] findShortestLongest(String[][] wordsWithLen) {
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        String shortest = "", longest = "";
        for (int i = 0; i < wordsWithLen.length; i++) {
            int len = Integer.parseInt(wordsWithLen[i][1]);
            if (len < minLen) {
                minLen = len;
                shortest = wordsWithLen[i][0];
            }
            if (len > maxLen) {
                maxLen = len;
                longest = wordsWithLen[i][0];
            }
        }
        return new String[]{shortest, longest};
    }

    public static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32); 
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    
    public static int[] countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < getStringLength(str); i++) {
            String type = charType(str.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

  
    public static int[] trimStringIndexes(String str) {
        int start = 0, end = getStringLength(str) - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String substringCustom(String str, int start, int end) {
        String sub = "";
        for (int i = start; i <= end; i++) {
            sub += str.charAt(i);
        }
        return sub;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (getStringLength(str1) != getStringLength(str2)) return false;
        for (int i = 0; i < getStringLength(str1); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Length (custom): " + getStringLength(input));
        System.out.println("Length (built-in): " + input.length());

        String[] customSplit = splitIntoWords(input);
        String[] builtinSplit = input.split(" ");

        System.out.println("Split comparison: " + compareStringArrays(customSplit, builtinSplit));

        String[][] wordsLen = wordsWithLengths(customSplit);
        System.out.println("\nWord\tLength");
        for (String[] wl : wordsLen) {
            System.out.println(wl[0] + "\t" + wl[1]);
        }

        String[] shortLong = findShortestLongest(wordsLen);
        System.out.println("\nShortest word: " + shortLong[0]);
        System.out.println("Longest word: " + shortLong[1]);

        int[] counts = countVowelsConsonants(input);
        System.out.println("\nVowels: " + counts[0] + ", Consonants: " + counts[1]);

        int[] trimIndexes = trimStringIndexes(input);
        String trimmedCustom = substringCustom(input, trimIndexes[0], trimIndexes[1]);
        String trimmedBuiltIn = input.trim();
        System.out.println("\nTrimmed (custom): '" + trimmedCustom + "'");
        System.out.println("Trimmed (built-in): '" + trimmedBuiltIn + "'");
        System.out.println("Trimmed equal? " + compareStrings(trimmedCustom, trimmedBuiltIn));
    }
}
