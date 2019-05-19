package sort;

import java.util.Arrays;

public class MyQuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 1, 6, 5, 4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int partition = partiton(arr, start, end);

        if(start < partition - 1) {
            quickSort(arr, start, partition - 1);
        }

        if(partition < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partiton(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
