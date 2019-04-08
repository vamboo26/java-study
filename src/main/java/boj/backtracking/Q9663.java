package boj.backtracking;

import java.util.Scanner;

//N Queen
//TODO : Googled solution
public class Q9663 {
    private static int[] positions = new int[16];
    private static int gridSize;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gridSize = sc.nextInt();

        for (int i = 0; i < gridSize; i++) {
            positions[0] = i;
            nQueen(i, 0);
        }

        System.out.println(answer);
    }

    private static void nQueen(int x, int y) {
        for (int i = 0; i < y; i++) {
            if (positions[i] == x || Math.abs(x - positions[i]) == y - i)
                return;
        }

        if (y == gridSize - 1) {
            answer++;
            return;
        }

        for (int i = 0; i < gridSize; i++) {
            positions[y + 1] = i;
            nQueen(i, y + 1);
        }
    }
}
