package boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//하노이탑
//TODO : Googled solution
public class Q1914 {

    static int count = 0;
    static int[][] path = new int[20000][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        movePlate(n, 1, 3);

        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(path[i][0] + " " + path[i][1]);
        }
    }

    private static void movePlate(int n, int from, int to) {
        int mid = 6 - from - to;

        if (n == 1) {
            path[count][0] = from;
            path[count][1] = to;
            count++;
            return;
        }

        movePlate(n - 1, from, mid);
        path[count][0] = from;
        path[count][1] = to;
        count++;
        movePlate(n - 1, mid, to);
    }
}

