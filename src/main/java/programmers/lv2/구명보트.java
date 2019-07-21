package programmers.lv2;

import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int count = 0;

        for (int j = people.length - 1; j > i; j--) {
            if(people[i] + people[j] <= limit) {
                i++;
            }

            count++;
        }

        return count;
    }

    public int 참고풀이(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

}
