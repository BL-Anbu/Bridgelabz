package Day_5_Practice_Problem;

import java.util.Scanner;

public class HarmonicNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        float result=0;
        for(int i=1;i<=n;i++){
            result += (float) (1.0/i);
        }
        System.out.println("The Harmonic Number of "+n+" is " + result);
    }
}
