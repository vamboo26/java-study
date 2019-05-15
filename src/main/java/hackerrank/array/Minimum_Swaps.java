package hackerrank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
//TODO Pair, ArrayList 쓰면 접근이 조금 편함, 배열 그대로 쓰면 인덱스 고려해줘야함
public class Minimum_Swaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int count = 0;
        int n = arr.length;

        Map<Integer, Integer> rm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rm.put(i, arr[i]);
        }

        boolean[] visit = new boolean[n];
        Arrays.fill(visit, false);

        for (int i = 0; i < n; i++) {
            if(visit[i] || rm.get(i) == i + 1) {
                continue;
            }

            int nextIndex = i;
            int circleSize = 0;

            while(!visit[nextIndex]) {
                visit[nextIndex] = true;

                nextIndex = rm.get(nextIndex) - 1;
                circleSize++;
            }

            if(circleSize > 0) {
                count += (circleSize - 1);
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}