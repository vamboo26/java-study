package codility;

import org.junit.Test;

public class CountFactors {

    public int solution(int N) {
        int result = 0;

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                result++;

                if(i < Math.sqrt(N)) {
                    result++;
                }
            }
        }

        return result;
    }

    public int solution2(int N) {
        int result = 0;
        double limit = Math.sqrt(N);

        for (int i = 1; i <= limit; i++) {
            if(N % i == 0) {
                result++;

                if(i < limit) {
                    result++;
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        int a = 1;
        double b = 0.5;

        Object c = a - b;
        System.out.println(c.getClass());
    }


}
