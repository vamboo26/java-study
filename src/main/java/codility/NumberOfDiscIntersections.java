package codility;

import org.junit.Test;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    //1st try, 17min, 빵점!!!
    public int solution(int[] A) {
        int[] min = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            min[i] = i - A[i];
        }

        Arrays.sort(min);

        int count = 0;

        for (int i = 0; i < A.length; i++) {

            for (int j = i + 1; j < A.length; j++) {
                if (i + A[i] > j - A[j]) {
                    count++;
                }
            }
        }

        return (count != 0) ? count : -1;
    }

    //TODO googled https://github.com/Mickey0521/Codility/blob/master/NumberOfDiscIntersections.java
    // 100! 3번 풀이와 어떤 차이가 있을까 O(N*log(N)) or O(N)
    public int solution2(int[] A) {

        // main idea:
        // 1. store all the "lower points" and "upper points" of the discs
        // 2. count the intersections (if one upper point > one lower point)

        // note: use "long" for big numbers (be careful)
        long[] lower = new long[A.length];
        long[] upper = new long[A.length];

        for(int i=0; i<A.length; i++){
            lower[i] = i - (long)A[i]; // note: lower = center - A[i]
            upper[i] = i + (long)A[i]; // note: upper = center + A[i]
        }

        // "sort" the "lower points" and "upper points"
        Arrays.sort(upper);
        Arrays.sort(lower);

        int intersection = 0; // number of intersections
        int j=0; // for the lower points

        // scan the upper points
        for(int i=0; i<A.length; i++){

            // for the curent "j" (lower point)
            while( j < A.length && upper[i] >= lower[j]){
                intersection = intersection + j; // add j intersections
                intersection = intersection - i; // minus "i" (avoid double count)
                j++;
            }
        }

        // for the overflow cases
        if(intersection > 10_000_000)
            return -1;

        return intersection; // number of intersections
    }

    //정확도100, 퍼포먼스25 -> 62점
    public int solution3(int[] A) {
        int N = A.length;
        long[] beginPoints = new long[N];
        long[] endPoints = new long[N];

        for (int i = 0; i < N; i++) {
            beginPoints[i] = (long) i - A[i];
            endPoints[i] = (long) i + A[i];
        }

        Arrays.sort(beginPoints);
        Arrays.sort(endPoints);

        int intersection = 0;
        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j < N && beginPoints[i] > endPoints[j]) {
                j++;
            }
            intersection += (i - j);
        }

        return (intersection > 10_000_000) ? -1 : intersection;
    }

    @Test
    public void test() {
        int[] A = new int[]{1, 5, 2, 1, 4, 0};
        System.out.println(solution3(A));
    }

}
