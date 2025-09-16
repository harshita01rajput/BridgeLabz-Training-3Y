import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exp = sc.nextInt();

        long result = 1;
        int i = 1;
        while (i <= exp) {
            result *= base;
            i++;
        }

        System.out.println(base + " ^ " + exp + " = " + result);
    }
}
