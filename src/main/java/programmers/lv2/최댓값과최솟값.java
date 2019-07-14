package programmers.lv2;

import java.util.Arrays;

public class 최댓값과최솟값 {

    public String solution(String s) {
        int[] splitedAndConverted = Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
        return splitedAndConverted[0] + " " + splitedAndConverted[splitedAndConverted.length - 1];
    }

    public String solution2(String s) {
        String[] splited = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String each : splited) {
            int value = Integer.parseInt(each);

            if(value > max) {
                max = value;
            }

            if(value < min) {
                min = value;
            }
        }

        return min + " " + max;
    }

}
