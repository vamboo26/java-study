package boj.sort.quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//스타대회
public class Q1608 {
    private static int n;
    private static String[] intimates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        intimates = new String[n];

        for (int i = 0; i < n; i++) {
            intimates[i] = br.readLine();
        }


    }

}
