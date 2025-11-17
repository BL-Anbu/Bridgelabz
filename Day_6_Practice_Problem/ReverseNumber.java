package Day_6_Practice_Problem;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        int result = 0;
        int remainder = 0;

        while (num != 0) {
            remainder=num%10;
            result =result*10 + remainder;
            num /= 10;
        }
        System.out.println(" reverse number is "+ result);
    }
}
