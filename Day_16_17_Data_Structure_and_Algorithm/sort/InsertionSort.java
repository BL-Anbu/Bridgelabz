package Day_16_17_Data_Structure_and_Algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3, 9, 7, 8};

        System.out.print("Original order : ");
        System.out.println(Arrays.toString(array));

        System.out.print("Insertion order : ");
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

}
