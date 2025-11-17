package Day_6_Practice_Problem;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
//        fibonacciSeriesUsingLoop(n);
//        fibonacciSeriesUsingRecursion(n);
        fibonacciSeriesUsingDynamicProgramming(n);
    }

    private static void fibonacciSeriesUsingDynamicProgramming(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(dp, i) + " ");
        }
    }

    public static int fib(int[] dp, int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (dp[n] != -1) return dp[n]; // return already computed

        dp[n] = fib(dp, n - 1) + fib(dp, n - 2);
        return dp[n];
    }

//    public static int fib(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return fib(n - 1) + fib(n - 2);
//    }

    private static void fibonacciSeriesUsingRecursion(int n) {
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i <= n; i++) {
//            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }

    private static void fibonacciSeriesUsingLoop(int n) {
        int a = 0;
        int b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
    }
}
