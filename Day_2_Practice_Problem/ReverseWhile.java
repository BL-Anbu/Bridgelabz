package Day_2_Practice_Problem;

import java.util.Scanner;

public class ReverseWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int rev = 0;

        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }

        System.out.println("Reversed number: " + rev);
        sc.close();
    }
}

