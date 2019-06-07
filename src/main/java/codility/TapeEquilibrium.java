package codility;

import org.junit.Test;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int left = 0;
        int right = 0;
        for (int each : A) {
            right += each;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            min = Math.min(min, Math.abs(left - right));
        }

        return min;
    }

    @Test
    public void test() {
        int[] A = {-1000,1000};
        System.out.println(solution(A));
    }

}
