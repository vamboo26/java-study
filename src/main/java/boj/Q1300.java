package boj;

import java.io.*;

//K번째수
//TODO : Googled solution
public class Q1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int n = Integer.parseInt(br.readLine());
//        int k = Integer.parseInt(br.readLine());

        int n = 5;
        int k = 12;

        int low = 1, high = k;
        int result = -1;

        while (low <= high) {
            int count = 0;
            int mid = (low + high) / 2;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k)
                low = mid + 1;
            else {
                result = mid;
                high = mid - 1;
            }
        }

//        System.out.println(Integer.toString(result));
        bw.write(String.valueOf(result));
        bw.flush();

    }

}
