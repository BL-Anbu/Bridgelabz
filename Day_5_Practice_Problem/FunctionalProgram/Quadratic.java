package Day_5_Practice_Problem.FunctionalProgram;

public class Quadratic {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Quadratic a b c");
        }
        quadratic(1,-3,2);
    }
    public static void quadratic(int a,int b,int c){
        try {

            if (a == 0) {
                System.out.println("Coefficient a must not be 0 for a quadratic equation.");
                return;
            }

            double delta = b * b - 4 * a * c;
            System.out.println("Delta = " + delta);

            if (delta > 0) {
                double r1 = (-b + Math.sqrt(delta)) / (2 * a);
                double r2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Two real roots: " + r1 + " and " + r2);
            } else if (delta == 0) {
                double r = -b / (2 * a);
                System.out.println("One real root (double): " + r);
            } else {
                double real = -b / (2 * a);
                double imag = Math.sqrt(-delta) / (2 * a);
                System.out.println("Two complex roots: " + real + "+" + imag + "i and " + real + "-" + imag + "i");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please provide numeric values for a, b, c.");
        }

    }}
