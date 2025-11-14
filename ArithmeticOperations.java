import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double e1 = a + b * c;
        double e2 = c + a / b;
        double e3 = a % b + c;
        double e4 = a * b + c;

        double max = Math.max(Math.max(e1, e2), Math.max(e3, e4));
        double min = Math.min(Math.min(e1, e2), Math.min(e3, e4));

        System.out.println("Results: " + e1 + ", " + e2 + ", " + e3 + ", " + e4);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        sc.close();
    }
}
