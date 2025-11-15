package Day_2_Practice_Problem;

import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (m): ");
        int m = sc.nextInt();
        System.out.print("Enter day (d): ");
        int d = sc.nextInt();

        boolean spring = (m == 3 && d >= 20) || (m == 4) || (m == 5) || (m == 6 && d <= 20);
        System.out.println(spring);
        sc.close();
    }
}
