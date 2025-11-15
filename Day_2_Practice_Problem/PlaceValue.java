package Day_2_Practice_Problem;

import java.util.Scanner;

public class PlaceValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1, 10, 100, or 1000: ");
        int num = sc.nextInt();

        if (num == 1)
            System.out.println("Unit");
        else if (num == 10)
            System.out.println("Ten");
        else if (num == 100)
            System.out.println("Hundred");
        else if (num == 1000)
            System.out.println("Thousand");
        else
            System.out.println("Invalid number!");
        sc.close();
    }
}
