package hackerrank;

import org.junit.Test;

import java.util.Arrays;

public class SockMerchant {
     static int sockMerchant(int n, int[] ar) {
         int answer = 0;

         Arrays.sort(ar);

        for (int i = 0; i < n - 1; i++) {
            if(ar[i] == ar[i + 1]) {
                answer++;
                i++;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println("(\r\n|[\n\r\u2028\u2029\u0085])?");
    }
}
