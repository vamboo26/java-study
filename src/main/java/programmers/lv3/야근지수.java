package programmers.lv3;

import java.util.Arrays;

public class 야근지수 {

    public long solution(int n, int[] works) {
        Arrays.sort(works);
        int max = works[works.length - 1];

        while(n > 0 && max > 0) {
            for (int j = works.length - 1; j >= 0; j--) {
                if(works[j] >= max && n > 0) {
                    works[j]--;
                    n--;
                    max = works[works.length - 1];
                }
            }
        }

        return Arrays.stream(works).mapToLong(i -> i * i).sum();
    }

}
