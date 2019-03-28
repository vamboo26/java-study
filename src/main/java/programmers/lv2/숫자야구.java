package programmers.lv2;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 숫자야구 {

    //TODO : Googled solution
    public int solution(int[][] baseball) {
        int count = 0;

        for (int i = 123; i <= 987; i++) {
            String target = String.valueOf(i);
            boolean flag = true;

            if(!target.contains("0")
                    && target.charAt(0) != target.charAt(1)
                    && target.charAt(1) != target.charAt(2)
                    && target.charAt(0) != target.charAt(2)) {
                for (int[] ints : baseball) {
                    String one = String.valueOf(ints[0]);
                    int strikes = countStrikes(one, target);
                    int balls = countBalls(one, target, strikes);

                    if (strikes != ints[1] || balls != ints[2]) {
                        flag = false;
                    }
                }

                if(flag) {
                    count++;
                }
            }
        }

        return count;
    }

    private int countStrikes(String one, String target) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            count = one.charAt(i) == target.charAt(i) ? count + 1 : count;
        }
        return count;
    }

    private int countBalls(String one, String target, int strikes) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            count = one.contains(String.valueOf(target.charAt(i))) ? count + 1 : count;
        }
        return count - strikes;
    }

    @Test
    public void test() {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        assertThat(solution(baseball)).isEqualTo(2);
    }
}
