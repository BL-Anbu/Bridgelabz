package Day_5_Practice_Problem;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year need to check its leaf year or not : ");
        int year = sc.nextInt();
        if (year < 1000 || year > 9999) {
            System.out.println("Enter 4 digit year only...");
        } else {
            boolean isLeaf = false;

            if (year % 400 == 0) {
                isLeaf = true;
            } else if (year % 100 == 0) {
                isLeaf = false;
            } else if (year % 4 == 0) {
                isLeaf = true;
            }
            if (isLeaf) {
                System.out.print("THe given year" + year + " is Leaf Year");
            } else {
                System.out.print("THe given year " + year + " is Leaf Year");
            }
        }
    }
}
