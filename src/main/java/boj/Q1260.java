package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//DFS와 BFS
public class Q1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");

        int n = Integer.valueOf(first[0]);
        int m = Integer.valueOf(first[1]);
        int v = Integer.valueOf(first[2]);

        int[][] nodes = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] node = br.readLine().split(" ");
            nodes[i][0] = Integer.valueOf(node[0]);
            nodes[i][1] = Integer.valueOf(node[1]);
        }

        for (int[] node : nodes) {
            System.out.print(node[0] +"," +node[1]);
            System.out.println("");
        }
    }

    private void dfs() {

    }

    private void bfs() {

    }

    public void test() {

    }
}
