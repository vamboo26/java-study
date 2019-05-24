package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class Q2589 {
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(stk.nextToken());
        int width = Integer.parseInt(stk.nextToken());

        boolean[][] map = new boolean[height][width];
        visit = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < height; j++) {
                map[i][j] = line[j].equals("L");
            }
        }

    }

    private static int dfs(boolean[][] map, int i, int j) {
        return 0;
    }

}
