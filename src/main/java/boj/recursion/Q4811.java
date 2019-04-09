package boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//알약
//TODO : Googled solution
public class Q4811 {
    private static long[][] memorize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;

        while ((n = Integer.valueOf(br.readLine())) != 0) {
            memorize = new long[2 * n + 1][2 * n + 1];
            int w = n - 1;
            int h = 1;
            System.out.println(split(w, h));
        }
    }

    private static long split(int w, int h) {
        if (w > 0) {
            if (memorize[w][h] != 0) {
                return memorize[w][h];
            }
        }

        if (w == 0) {
            memorize[w][h] = 1;
            return 1;
        }

        long sum = 0;
        sum += split(w - 1, h + 1);

        if(h >= 1) {
            sum += split(w, h - 1);
        }

        memorize[w][h] = sum;
        return sum;
    }
}
