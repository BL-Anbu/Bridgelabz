package Day_16_17_Data_Structure_and_Algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3, 9, 7, 8};

        System.out.print("Original order : ");
        System.out.println(Arrays.toString(array));
        selectionSort(array);

        System.out.print("Selection order : ");
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
