package codility;

import org.junit.Test;

import java.util.*;

public class MissingInteger {

    /**
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     */

    //정확도 100, 퍼포먼스 75, 총 88점, O(N) or O(N * log(N))
    public int solution(int[] A) {
        int[] refined = Arrays.stream(A)
                .filter(i -> i > 0)
                .distinct()
                .sorted()
                .toArray();
        int length = refined.length;

        if(length == 0 || refined[0] != 1) {
            return 1;
        }

        for (int i = 0; i < length - 1; i++) {
            if(refined[i + 1] - refined[i] != 1)
                return refined[i] + 1;
        }

        return refined[length - 1] + 1;
    }

    //TODO
    // googled, https://stroot.tistory.com/92 [Strong Root] O(N) or O(N * log(N))
    public int solution2(int[] A) {
        Set<Integer> refinedNumbers = new HashSet<>();

        for (int each : A) {
            refinedNumbers.add(each);
        }

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!refinedNumbers.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    //TODO 해쉬에서 search가 최악에 O(N)인데 Array에서도 O(N)이면 굳이 해쉬에 안넣어도되지 않을까?
    // O(N) or O(N * log(N)) 처음에 정렬해줘야하는데 이건...? 흠 일단 테스트케이스에서 성능은 나옴
    public int solution3(int[] A) {
        Arrays.sort(A);
        for (int i = 1; true; i++) {
            if (Arrays.binarySearch(A, i) <= 0) {
                return i;
            }
        }
    }

    @Test
    public void test() {
        int[] A = {1,1,1,2,4};
        System.out.println(Arrays.binarySearch(A,3));
        float a = 0.1f;
        float b = 0.2f;
        System.out.println(a + b);

    }

}
