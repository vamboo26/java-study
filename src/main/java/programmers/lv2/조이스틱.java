package programmers.lv2;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 조이스틱 {

    //TODO : Googled solution
    public int solution(String name) {
        int count = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            char current = name.charAt(i);

            if (current <= 'N') {
                count += current - 'A';
            } else {
                count += 'Z' - current + 1;
            }

            int targetPosition = i + 1;

            while (targetPosition < name.length() && name.charAt(targetPosition) == 'A') {
                targetPosition++;
            }

            int forwardMove = i;
            int reverseMove = name.length() - targetPosition;

            int expectedMove = forwardMove <= reverseMove ? forwardMove * 2 + reverseMove : forwardMove + reverseMove * 2;
            move = Math.min(move, expectedMove);
        }

        count += move;
        return count;
    }


    @Test
    public void test() {
        String name = "ABAAAAAAAAABB";
        assertThat(solution(name)).isEqualTo(7);
    }
}
