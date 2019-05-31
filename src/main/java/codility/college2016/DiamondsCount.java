package codility.college2016;

import org.junit.Test;

import java.util.*;

public class DiamondsCount {


    //못풀겠다!!!
    public int solution(int[] X, int[] Y) {
        return 0;
    }

    private class Point {

        private int index;
        private int x;
        private int y;

        private Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }


    /**
     * N is an integer within the range [4..1,500];
     * each element of arrays X, Y is an integer within the range [0..N−1];
     * given N points are pairwise distinct.
     */

    @Test
    public void test() {
        int[] X = {1, 2, 3, 3, 2, 1};
        int[] Y = {1, 1, 1, 2, 2, 2};
//        System.out.println(solution(X, Y));

        System.out.println(2^3^2);
        System.out.println(1^2^3);
        System.out.println(1^2);
        System.out.println(2^3);
    }
}
