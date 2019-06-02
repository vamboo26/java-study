package codility;

public class CountFactors {

    public int solution(int N) {
        int result = 0;
        int limit = (int) Math.sqrt(N);

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

}
