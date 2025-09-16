import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        
        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / 6.4516; // 1 inch² = 6.4516 cm²
        
        System.out.println("The area of triangle in square cm is " + areaCm + " and in square inches is " + areaInches);
        input.close();
    }
}
