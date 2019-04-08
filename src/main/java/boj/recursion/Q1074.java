package boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
    private static int N;
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        r = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());

        System.out.println(recursiveZ(0, 0));
    }

    private static int recursiveZ(int x, int y) {
        return 0;
    }
}
