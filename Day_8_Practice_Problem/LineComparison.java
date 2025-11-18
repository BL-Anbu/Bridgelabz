package Day_8_Practice_Problem;

public class LineComparison {

    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");

        Point a1 = new Point(0, 0);
        Point b1 = new Point(3, 4);
        Line line1 = new Line(a1, b1);

        Point a2 = new Point(1, 1);
        Point b2 = new Point(4, 5);
        Line line2 = new Line(a2, b2);

        System.out.printf("Line1: %s%n", line1);
        System.out.printf("Line2: %s%n", line2);

        System.out.printf("Line1 equals Line2 by length? %b%n", line1.equals(line2));
        int cmp = line1.compareTo(line2);
        String cmpMessage = (cmp == 0) ? "equal to" : (cmp < 0 ? "shorter than" : "longer than");
        System.out.printf("Line1 is %s Line2%n", cmpMessage);

    }
}
