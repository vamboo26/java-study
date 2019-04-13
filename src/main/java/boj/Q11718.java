package boj;

import java.io.*;

public class Q11718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str = br.readLine()) != null) {
            bw.write(str + "\n");
        }

        bw.close();
        br.close();
    }
}
