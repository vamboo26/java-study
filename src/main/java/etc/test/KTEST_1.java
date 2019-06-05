package etc.test;

import org.junit.Test;

public class KTEST_1 {
    //16분

    public int solution(int[] v) {
        int sum = 0;
        int combo = 0;

        for (int i = 0; i < v.length; i++) {
            if(v[i] != 0) {
                combo++;
                sum += (i + 1) * combo;
            } else {
                combo = 0;
            }
        }

        return sum;
    }

    @Test
    public void test() {
        int[] v = {0,1,1,0,1,1,1,0};
        System.out.println(solution(v));
    }

}
