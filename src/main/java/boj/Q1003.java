package boj;

import java.io.*;

public class Q1003 {

    private static int[][] dp = new int[40][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(br.readLine());
        int[] cases = new int[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            cases[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[40][2];


        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int eachCase : cases) {
            System.out.println(dp[eachCase][0] + " " + dp[eachCase][1]);
        }

        br.close();
    }

    //googled : https://www.acmicpc.net/source/13430314

}
