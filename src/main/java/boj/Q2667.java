package boj;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfComplexes = Integer.parseInt(br.readLine());
        int[][] building = new int[numberOfComplexes][numberOfComplexes];
        Queue<Integer> result = new PriorityQueue<>();

        for (int i = 0; i < numberOfComplexes; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < numberOfComplexes; j++) {
                building[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < numberOfComplexes; i++) {
            for (int j = 0; j < numberOfComplexes; j++) {

                int count = 0;
                count += dfs(building, i, j);

                if(count > 0) {
                    result.add(count);
                }
            }
        }

        bw.write(result.size() + "\n");

        while(!result.isEmpty())
            bw.write(result.poll() + "\n");

        bw.flush();
    }

    private static int dfs(int[][] buildings, int i, int j) {
        if(i < 0 || j < 0 || i > buildings.length - 1 || j > buildings.length - 1 || buildings[i][j] == 0) {
            return 0;
        }

        buildings[i][j] = 0;

        return 1 + dfs(buildings, i + 1, j)
                + dfs(buildings, i, j + 1)
                + dfs(buildings, i - 1, j)
                + dfs(buildings, i, j - 1);
    }

}
