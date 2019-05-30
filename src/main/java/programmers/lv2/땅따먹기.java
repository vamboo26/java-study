package programmers.lv2;

import org.junit.Test;

import static java.lang.Integer.max;

public class 땅따먹기 {

    private static int[][] dp = new int[100001][4];

    int solution(int[][] land) {
        int numberOfRow = land.length;

        System.arraycopy(land[0], 0, dp[0], 0, 4);
//        for (int i = 0; i < 4; i++) {
//            dp[0][i] = land[0][i];
//        }

        for (int i = 1; i < numberOfRow; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        dp[i][j] = max(dp[i][j], land[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[numberOfRow - 1][i]);
        }

        return answer;
    }

    int solution2(int[][] land) {
        int size = land.length;

        for (int i = 1; i < size; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        return Math.max(land[size - 1][0], Math.max(land[size - 1][1], Math.max(land[size - 1][2], land[size - 1][3])));
    }


    @Test
    public void test() {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution(land));
        System.out.println(solution2(land));
    }

}
