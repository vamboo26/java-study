package boj.sort;

import java.io.*;

//수 정렬하기2
public class Q2751 {
    private static int n;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.valueOf(br.readLine());
        }

        quickSort(numbers, 0, n - 1);

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int number : numbers) {
            bf.write(number + "\n");
        }

        bf.close();
        br.close();
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while (arr[left] < pivot && left < right) {
                left++;
            }

            while ((arr[right] > pivot) && left < right) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        return left;
    }
}
