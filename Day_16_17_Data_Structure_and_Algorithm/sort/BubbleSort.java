package Day_16_17_Data_Structure_and_Algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3, 9, 7, 8};
        System.out.print("Original order : ");
        System.out.println(Arrays.toString(array));

        int[] array1 = Arrays.stream(array).toArray();

        bubbleSortDESC(array);
        System.out.println(Arrays.toString(array));

        bubbleSortASC(array1);
        System.out.println(Arrays.toString(array1));
    }

    private static void bubbleSortDESC(int[] array) {
        System.out.print("Descending order : ");
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    private static void bubbleSortASC(int[] array) {
        System.out.print("Ascending order : ");
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

}
