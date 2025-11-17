package Day_5_Practice_Problem.FunctionalProgram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSumCubic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        int[] a = new int[N];
        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) a[i] = sc.nextInt();

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        List<Integer> t = Arrays.asList(a[i], a[j], a[k]);
                        triplets.add(t);
                    }
                }
            }
        }

        System.out.println("Number of distinct triplets that sum to 0: " + triplets.size());
        for (List<Integer> t : triplets) {
            System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
        }
        sc.close();
    }
}
