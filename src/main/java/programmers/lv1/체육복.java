package programmers.lv1;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int alreadyHas = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    alreadyHas++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] != -1 && borrowable(lost[i], reserve[j])) {
                    alreadyHas++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return alreadyHas;
    }

    private boolean borrowable(int myIndex, int targetIndex) {
        return Math.abs(myIndex - targetIndex) == 1;
    }

    @Test
    public void test() {
        int n = 5;
        int[] lost = {2,3,5};
        int[] reserve = {3};
        assertThat(solution(n, lost, reserve)).isEqualTo(4);
    }
}
