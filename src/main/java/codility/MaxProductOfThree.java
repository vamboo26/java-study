package codility;

import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);
        int left = A[0] * A[1] * A[A.length - 1];
        int rigth = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

        return Math.max(left, rigth);
    }

}
