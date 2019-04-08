package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

//미로 탐색
public class Q2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();

        int n = Integer.valueOf(size.split(" ")[0]);
        int m = Integer.valueOf(size.split(" ")[1]);

        int[][] grid = new int[n][m];

        for (int i = 0; i < grid.length; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.valueOf(line[j]);
            }
        }
    }
}
