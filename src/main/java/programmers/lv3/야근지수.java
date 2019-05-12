package programmers.lv3;

import java.util.Arrays;

public class 야근지수 {

    public long solution(int n, int[] works) {
        Arrays.sort(works);
        int max = works[works.length - 1];

        while(n > 0 && max > 0) {
            max = works[works.length - 1];
            for (int j = works.length - 1; j >= 0; j--) {
                if(n > 0 && works[j] == max && max > 0) {
                    works[j]--;
                    n--;
                }
            }
        }

        return Arrays.stream(works).mapToLong(i -> i * i).sum();
    }

}
