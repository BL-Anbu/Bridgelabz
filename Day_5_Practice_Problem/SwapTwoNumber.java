package Day_5_Practice_Problem;

import java.util.Scanner;

public class SwapTwoNumber {
    public static void main(String[] args) {
        final int n = 0;
        final int m = 20;
        swapTwoNumWithTemp(n, m);
//        swapTwoNumWithoutTemp(n, m);

    }

    private static void swapTwoNumWithoutTemp(int n, int m) {
        System.out.println("Before Swap \n N is " + n + " and M is " + m);
        n = n + m;
        m = n - m;
        n = n - m;
        System.out.println("After Swap \n N is " + n + " and M is " + m);

    }

    private static void swapTwoNumWithTemp(int n, int m) {
        System.out.println("Before Swap \n N is " + n + " and M is " + m);
        int temp = m;
        m = n;
        n = temp;
        System.out.println("After Swap \n N is " + n + " and M is " + m);
    }
}
