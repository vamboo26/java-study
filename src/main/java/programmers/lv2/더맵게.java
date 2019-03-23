package programmers.lv2;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> sortedScoville = new PriorityQueue<>();
        for (int i : scoville) {
            sortedScoville.add(i);
        }

        int answer = 0;

        while(sortedScoville.size() > 1 && sortedScoville.peek() < K) {
            sortedScoville.add(sortedScoville.poll() + sortedScoville.poll() * 2);
            answer++;
        }

        return sortedScoville.peek() < K ? -1 : answer;
    }

    @Test
    public void test() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        assertThat(solution(scoville, K)).isEqualTo(2);
    }
}
