package programmers.lv2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 탑 {
    public int[] solution(int[] heights) {
        List<Tower> towers = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            towers.add(new Tower(i + 1, heights[i]));
        }

        towers.add(new Tower(0,0));

        int[] result = new int[heights.length];

        for (int i = 1; i < heights.length; i++) {
            for (int j = i; j >= 0; j--) {
                if(towers.get(j).canGetSignal(towers.get(i))) {
                    result[i] = towers.get(j).location;
                    break;
                }
            }
        }

        return result;
    }

    class Tower {
        int location;
        int height;

        public Tower(int location, int height) {
            this.location = location;
            this.height = height;
        }

        public boolean canGetSignal(Tower target) {
            return this.height > target.height;
        }
    }

    //심플, 더 가까운 탑으로 결과를 덮어가며 탐색
    public int[] looksBetter(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i=0; i<heights.length; i++){
            for (int j=i+1; j<heights.length; j++){
                if (heights[i] > heights[j]){
                    answer[j]=i+1;
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        int[] heights = {6,9,5,7,4};
        int[] result = {0,0,2,2,4};
        assertThat(solution(heights)).isEqualTo(result);
    }
}

