package codility;

import org.junit.Test;

public class TieRopes {

    //10min, O(N), 100!, 더 나은 코드는 없을까? 굳이 첫 for문 필요없음
    public int solution(int K, int[] A) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] >= K) {
                count++;
                A[i] = -1;
            }
        }

        int temporarySum = 0;

        for (int each : A) {
            if (each == -1) {
                temporarySum = 0;
                continue;
            }

            temporarySum += each;

            if (temporarySum >= K) {
                count++;
                temporarySum = 0;
            }
        }

        return count;
    }

    public int solution2(int K, int[] A) {
        int count = 0;
        int currentLength = 0;

        for (int each : A) {
            currentLength += each;
            if(currentLength >= K) {
                count++;
                currentLength = 0;
            }
        }

        return count;
    }

    @Test
    public void test() {
        int[] A = {1,2,3,4,1,1,3};
        int K = 4;
        System.out.println(solution2(K, A));
    }

}
