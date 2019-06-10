package codility;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);

            if(numbers.size() == X) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        int[] A = {1};
        System.out.println(solution(1, A));
    }

}
