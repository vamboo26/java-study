package boj.sort.quick;

import org.junit.Test;

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
        intimates = new String[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            intimates[i] = br.readLine();
        }

        for (int i = 1; i <= n; i++) {
            if(canBeWinner(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean canBeWinner(int index) {
        String str = intimates[index];
        if(str.startsWith("0")) {
            return false;
        }

        if(str.startsWith(String.valueOf(n - 1))) {
            return true;
        }

        for (int i = 1; i <= n; i++) {
            if(!str.substring(1).contains(String.valueOf(i)) && i != index) {
                if(intimates[i].substring(1).contains(String.valueOf(index))) {
                    return false;
                }
            }
        }

        return true;
    }
}
