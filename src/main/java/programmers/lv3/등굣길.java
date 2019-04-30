package programmers.lv3;

public class 등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] grid = new int[101][101];
        int[][] d = new int[101][101];
        d[1][0] = 1;

        for (int i = 0; i < grid.length; i++) {
            grid[0][i] = -1;
            grid[i][0] = -1;
        }

        for (int[] puddle : puddles) {
            grid[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(grid[i][j] == -1) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 1000000007;
                }
            }
        }

        return d[n][m];
    }

}
