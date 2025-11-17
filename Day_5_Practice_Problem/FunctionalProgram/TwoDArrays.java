package Day_5_Practice_Problem.FunctionalProgram;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows (n) : ");
        int n = sc.nextInt();
        System.out.print("Enter columns (m) : ");
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        getArrayValues(array);
        printArrayValues(array);
    }

    public static void printArrayValues(int[][] array) {
        System.out.println("The Matrix of Array is : ");
        for (int[] nums : array) {
            System.out.print("[ ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.print("]\n");
        }
    }

    private static void getArrayValues(int[][] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Element of [" + i + "] [" + j + "] = ");
                array[i][j] = sc.nextInt();
            }
        }
    }

}
