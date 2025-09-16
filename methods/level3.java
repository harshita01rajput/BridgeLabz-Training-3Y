import java.util.*;

class FootballTeamStats {
    public static int[] generateHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
        }
        return heights;
    }
    public static int sum(int[] arr) {
        int s = 0;
        for (int v : arr) s += v;
        return s;
    }
    public static double mean(int[] arr) {
        return sum(arr) / (double)arr.length;
    }
    public static int min(int[] arr) {
        int min = arr[0];
        for (int v : arr) if (v < min) min = v;
        return min;
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int v : arr) if (v > max) max = v;
        return max;
    }
}

class NumberChecker {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
    public static int[] digitsArray(int n) {
        int len = countDigits(n);
        int[] arr = new int[len];
        n = Math.abs(n);
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        return arr;
    }
    public static boolean isDuck(int n) {
        int[] arr = digitsArray(n);
        for (int i : arr) if (i == 0) return true;
        return false;
    }
    public static boolean isArmstrong(int n) {
        int[] arr = digitsArray(n);
        int sum = 0;
        for (int v : arr) sum += Math.pow(v, arr.length);
        return sum == n;
    }
    public static int[] largestTwo(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > first) { second = first; first = v; }
            else if (v > second) second = v;
        }
        return new int[]{first, second};
    }
    public static int[] smallestTwo(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int v : arr) {
            if (v < first) { second = first; first = v; }
            else if (v < second) second = v;
        }
        return new int[]{first, second};
    }
    public static int sumDigits(int n) {
        int[] arr = digitsArray(n);
        int sum = 0;
        for (int v : arr) sum += v;
        return sum;
    }
    public static int sumSquareDigits(int n) {
        int[] arr = digitsArray(n);
        int sum = 0;
        for (int v : arr) sum += Math.pow(v, 2);
        return sum;
    }
    public static boolean isHarshad(int n) {
        return n % sumDigits(n) == 0;
    }
    public static int[][] digitFrequency(int n) {
        int[] arr = digitsArray(n);
        int[] freq = new int[10];
        for (int v : arr) freq[v]++;
        int count = 0;
        for (int f : freq) if (f > 0) count++;
        int[][] result = new int[count][2];
        int idx = 0;
        for (int i = 0; i < 10; i++) if (freq[i] > 0) { result[idx][0] = i; result[idx][1] = freq[i]; idx++; }
        return result;
    }
    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        return rev;
    }
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) if (arr1[i] != arr2[i]) return false;
        return true;
    }
    public static boolean isPalindrome(int n) {
        return compareArrays(digitsArray(n), reverseArray(digitsArray(n)));
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }
    public static boolean isNeon(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) { sum += square % 10; square /= 10; }
        return sum == n;
    }
    public static boolean isSpy(int n) {
        int[] arr = digitsArray(n);
        int sum = 0, product = 1;
        for (int v : arr) { sum += v; product *= v; }
        return sum == product;
    }
    public static boolean isAutomorphic(int n) {
        int sq = n * n;
        return String.valueOf(sq).endsWith(String.valueOf(n));
    }
    public static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }
    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) if (n % i == 0) sum += i;
        return sum == n;
    }
    public static boolean isAbundant(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) if (n % i == 0) sum += i;
        return sum > n;
    }
    public static boolean isDeficient(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) if (n % i == 0) sum += i;
        return sum < n;
    }
    public static boolean isStrong(int n) {
        int[] arr = digitsArray(n);
        int sum = 0;
        for (int v : arr) {
            int fact = 1;
            for (int i = 1; i <= v; i++) fact *= i;
            sum += fact;
        }
        return sum == n;
    }
}

class FactorUtils {
    public static int[] factors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) arr[idx++] = i;
        return arr;
    }
    public static int sum(int[] arr) {
        int s = 0; for (int v : arr) s += v; return s;
    }
    public static int product(int[] arr) {
        int p = 1; for (int v : arr) p *= v; return p;
    }
    public static long productCube(int[] arr) {
        long p = 1; for (int v : arr) p *= Math.pow(v,3); return p;
    }
    public static int greatest(int[] arr) {
        int g = arr[0]; for (int v : arr) if (v > g) g = v; return g;
    }
}

class OTPGenerator {
    public static int generateOTP() {
        return 100000 + (int)(Math.random()*900000);
    }
    public static boolean isUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int o : otps) if (!set.add(o)) return false;
        return true;
    }
}

class CalendarUtils {
    public static String monthName(int m) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m-1];
    }
    public static boolean isLeap(int y) {
        return (y%4==0 && y%100!=0) || (y%400==0);
    }
    public static int daysInMonth(int m,int y) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (m==2 && isLeap(y)) return 29;
        return days[m-1];
    }
    public static int firstDay(int d,int m,int y) {
        int y0 = y - (14 - m)/12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14-m)/12) -2;
        return (d + x + (31*m0)/12) % 7;
    }
    public static void displayCalendar(int m,int y) {
        int days = daysInMonth(m,y);
        int fd = firstDay(1,m,y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i=0;i<fd;i++) System.out.print("    ");
        for (int i=1;i<=days;i++){
            System.out.printf("%3d ",i);
            if((i+fd)%7==0) System.out.println();
        }
        System.out.println();
    }
}

class CollinearPoints {
    public static boolean areCollinear(double x1,double y1,double x2,double y2,double x3,double y3) {
        double slope1 = (y2 - y1)/(x2 - x1);
        double slope2 = (y3 - y2)/(x3 - x2);
        double slope3 = (y3 - y1)/(x3 - x1);
        return slope1==slope2 && slope2==slope3;
    }
    public static boolean areCollinearArea(double x1,double y1,double x2,double y2,double x3,double y3){
        double area = 0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        return area==0;
    }
}

class EmployeeBonus {
    public static double[][] generateEmployees(){
        double[][] arr = new double[10][2];
        for(int i=0;i<10;i++){
            arr[i][0]=10000 + Math.random()*90000;
            arr[i][1]=(int)(Math.random()*10)+1;
        }
        return arr;
    }
    public static double[][] calculateBonus(double[][] arr){
        double[][] res = new double[10][3];
        for(int i=0;i<10;i++){
            res[i][0]=arr[i][0];
            res[i][1]=arr[i][1];
            res[i][2]=arr[i][1]>5?arr[i][0]*0.05:arr[i][0]*0.02;
        }
        return res;
    }
    public static void displayBonus(double[][] arr){
        double sumOld=0,sumNew=0,totalBonus=0;
        System.out.println("OldSalary Years Bonus NewSalary");
        for(int i=0;i<10;i++){
            sumOld+=arr[i][0];
            sumNew+=arr[i][0]+arr[i][2];
            totalBonus+=arr[i][2];
            System.out.printf("%.2f %.0f %.2f %.2f\n",arr[i][0],arr[i][1],arr[i][2],arr[i][0]+arr[i][2]);
        }
        System.out.printf("Total %.2f %.2f %.2f\n",sumOld,sumNew,totalBonus);
    }
}

class EuclideanUtils {
    public static double distance(double x1,double y1,double x2,double y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
    public static double[] lineEquation(double x1,double y1,double x2,double y2){
        double m=(y2-y1)/(x2-x1);
        double b=y1-m*x1;
        return new double[]{m,b};
    }
}

class StudentScores {
    public static int[][] generateScores(int n){
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=(int)(Math.random()*91)+10;
            arr[i][1]=(int)(Math.random()*91)+10;
            arr[i][2]=(int)(Math.random()*91)+10;
        }
        return arr;
    }
    public static double[][] calculateTotalAvgPerc(int[][] arr){
        double[][] res=new double[arr.length][3];
        for(int i=0;i<arr.length;i++){
            int sum=arr[i][0]+arr[i][1]+arr[i][2];
            res[i][0]=sum;
            res[i][1]=Math.round(sum/3.0*100.0)/100.0;
            res[i][2]=Math.round(sum/300.0*10000.0)/100.0;
        }
        return res;
    }
    public static void displayScorecard(int[][] arr,double[][] calc){
        System.out.println("Physics Chem Math Total Avg Perc");
        for(int i=0;i<arr.length;i++){
            System.out.printf("%d %d %d %.0f %.2f %.2f\n",arr[i][0],arr[i][1],arr[i][2],calc[i][0],calc[i][1],calc[i][2]);
        }
    }
}

class MatrixOps {
    public static int[][] createRandom(int r,int c){
        int[][] mat=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) mat[i][j]=(int)(Math.random()*10);
        return mat;
    }
    public static int[][] add(int[][] a,int[][] b){
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[i][j]=a[i][j]+b[i][j];
        return res;
    }
    public static int[][] subtract(int[][] a,int[][] b){
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[i][j]=a[i][j]-b[i][j];
        return res;
    }
    public static int[][] multiply(int[][] a,int[][] b){
        int r=a.length,c=b[0].length,n=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) for(int k=0;k<n;k++) res[i][j]+=a[i][k]*b[k][j];
        return res;
    }
}

class MatrixAdvancedOps {
    public static int[][] transpose(int[][] mat){
        int r=mat.length,c=mat[0].length;
        int[][] res=new int[c][r];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[j][i]=mat[i][j];
        return res;
    }
    public static int determinant2x2(int[][] mat){
        return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
    }
    public static int determinant3x3(int[][] mat){
        return mat[0][0]*(mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1])
             - mat[0][1]*(mat[1][0]*mat[2][2]-mat[1][2]*mat[2][0])
             + mat[0][2]*(mat[1][0]*mat[2][1]-mat[1][1]*mat[2][0]);
    }
    public static double[][] inverse2x2(int[][] mat){
        double det=determinant2x2(mat);
        return new double[][]{{mat[1][1]/det,-mat[0][1]/det},{-mat[1][0]/det,mat[0][0]/det}};
    }
    public static double[][] inverse3x3(int[][] mat){
        double det=determinant3x3(mat);
        double[][] res=new double[3][3];
        res[0][0]=(mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1])/det;
        res[0][1]=-(mat[0][1]*mat[2][2]-mat[0][2]*mat[2][1])/det;
        res[0][2]=(mat[0][1]*mat[1][2]-mat[0][2]*mat[1][1])/det;
        res[1][0]=-(mat[1][0]*mat[2][2]-mat[1][2]*mat[2][0])/det;
        res[1][1]=(mat[0][0]*mat[2][2]-mat[0][2]*mat[2][0])/det;
        res[1][2]=-(mat[0][0]*mat[1][2]-mat[0][2]*mat[1][0])/det;
        res[2][0]=(mat[1][0]*mat[2][1]-mat[1][1]*mat[2][0])/det;
        res[2][1]=-(mat[0][0]*mat[2][1]-mat[0][1]*mat[2][0])/det;
        res[2][2]=(mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0])/det;
        return res;
    }
    public static void display(int[][] mat){
        for(int[] row:mat){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
        }
    }
    public static void display(double[][] mat){
        for(double[] row:mat){
            for(double v:row) System.out.print(v+" ");
            System.out.println();
        }
    }
}

public class level3 {
    public static void main(String[] args){
        int[] heights = FootballTeamStats.generateHeights();
        System.out.println("Shortest: "+FootballTeamStats.min(heights));
        System.out.println("Tallest: "+FootballTeamStats.max(heights));
        System.out.println("Mean: "+FootballTeamStats.mean(heights));

        int[] fac = FactorUtils.factors(12);
        System.out.println(Arrays.toString(fac));
        System.out.println(FactorUtils.sum(fac));
        System.out.println(FactorUtils.product(fac));
        System.out.println(FactorUtils.productCube(fac));
        System.out.println(FactorUtils.greatest(fac));

        int[] otps = new int[10];
        for(int i=0;i<10;i++) otps[i]=OTPGenerator.generateOTP();
        System.out.println(Arrays.toString(otps));
        System.out.println(OTPGenerator.isUnique(otps));

        CalendarUtils.displayCalendar(7,2005);

        System.out.println(CollinearPoints.areCollinear(2,4,4,6,6,8));
        System.out.println(CollinearPoints.areCollinearArea(2,4,4,6,6,8));

        double[][] emp = EmployeeBonus.generateEmployees();
        double[][] bonus = EmployeeBonus.calculateBonus(emp);
        EmployeeBonus.displayBonus(bonus);

        System.out.println(EuclideanUtils.distance(0,0,3,4));
        double[] line = EuclideanUtils.lineEquation(0,0,3,4);
        System.out.println(Arrays.toString(line));

        int[][] scores = StudentScores.generateScores(5);
        double[][] calc = StudentScores.calculateTotalAvgPerc(scores);
        StudentScores.displayScorecard(scores,calc);

        int[][] a = MatrixOps.createRandom(2,2);
        int[][] b = MatrixOps.createRandom(2,2);
        MatrixAdvancedOps.display(MatrixOps.add(a,b));
        MatrixAdvancedOps.display(MatrixOps.subtract(a,b));
        MatrixAdvancedOps.display(MatrixOps.multiply(a,b));
        MatrixAdvancedOps.display(MatrixAdvancedOps.transpose(a));
        System.out.println(MatrixAdvancedOps.determinant2x2(a));
        double[][] inv = MatrixAdvancedOps.inverse2x2(a);
        MatrixAdvancedOps.display(inv);
    }
}
