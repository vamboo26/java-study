package etc;

import java.util.Arrays;

public class SortPractice {

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,13,23,22,12,17,16,14,15,8,4,9,6,11};
        System.out.println(Arrays.toString(arr));

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
            quickSort(arr, partition, end);
        }
    }

    private static int partiton(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];  //임의의 pivot, 보통 중위값(정렬되지 않았기에 어디든 상관없음)

        while(start <= end) {
            while(arr[start] < pivot) {
                start++;
            }

            while(arr[end] > pivot) {
                end--;
            }

            if(start <= end) {
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
