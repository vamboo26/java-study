package programmers.lv3;

import java.util.Arrays;

public class 저울 {

    public int solution(int[] weight) {
        Arrays.sort(weight);
        int sum = 1;

        for (int each : weight) {
            if(sum < each) {
                break;
            }

            sum += each;
        }

        return sum;
    }

}
