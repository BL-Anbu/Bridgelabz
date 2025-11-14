import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two Real Roots: " + r1 + ", " + r2);
        } else if (delta == 0) {
            double r = -b / (2 * a);
            System.out.println("One Real Root: " + r);
        } else {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-delta) / (2 * a);
            System.out.println("Complex Roots: " + real + " ± " + imag + "i");
        }
        sc.close();
    }
}

