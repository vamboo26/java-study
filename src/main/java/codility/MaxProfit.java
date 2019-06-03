package codility;

public class MaxProfit {

    public int solution(int[] A) {
        if(A.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int each : A) {
            min = Math.min(min, each);
            max = Math.max(max, each - min);
        }

        return max;
    }

}
