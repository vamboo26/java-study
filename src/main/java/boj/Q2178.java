package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        Queue<>

        System.out.println(searchMaze(grid, 0, 0));
    }

    private static int searchMaze(int[][] grid, int x, int y) {
        if(x == grid.length - 1 && y == grid[0].length - 1) {
            return 0;
        }

        if(grid[x][y + 1] == 1) {
            return 1 + searchMaze(grid, x, y + 1);
        }

        if(grid[x + 1][y] == 1) {
            return 1 + searchMaze(grid, x + 1, y);
        }

        return 1 + searchMaze(grid, x + 1, y);
    }
}
