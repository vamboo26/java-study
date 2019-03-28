package programmers.lv2;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 타겟넘버 {
    private static int answer = 0;

    //TODO : Googled solution
    public int solution(int[] numbers, int target) {
        findTarget(numbers, target, 0);
        return answer;
    }

    private void findTarget(int[] numbers, int target, int depth) {
        if(depth == numbers.length) {
            int sum = 0;

            for (int number : numbers) {
                sum += number;
            }

            if(sum == target) {
                answer++;
            }

            return;
        }

        numbers[depth] *= 1;
        findTarget(numbers, target, depth + 1);

        numbers[depth] *= -1;
        findTarget(numbers, target, depth + 1);
    }

    //TODO : Googled solution
    //전역변수 쓰지 않으며, int 반환
    public int 참고풀이(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            return (sum == target) ? 1 : 0;
        }

        return dfs(numbers, depth + 1, sum + numbers[depth], target) + dfs(numbers, depth + 1, sum - numbers[depth], target);
    }

    @Test
    public void test() {
        int[] numbers = new int[5];
        Arrays.fill(numbers, 1);

        assertThat(참고풀이(numbers, 3)).isEqualTo(5);
    }
}
