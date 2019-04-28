package programmers.lv3;

public class 타일장식물 {

    public long solution(int N) {
        long[] dp = new long[80];

        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1] ;
        }

        return (dp[N - 1] * 2 + dp[N - 2]) * 2;
    }

}
