package codility;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    //TODO Googled
    // https://github.com/ZRonchy/Codility/blob/master/Lesson13/MinAbsSumOfTwo.java
    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int tail = 0;
        int head = N - 1;
        int minAbsSum = Math.abs(A[tail] + A[head]);

        while (tail <= head) {
            int currentSum = A[tail] + A[head];
            minAbsSum = Math.min(minAbsSum, Math.abs(currentSum));
            if (currentSum <= 0)
                tail++;
            else
                head--;
        }
        return minAbsSum;
    }

}
