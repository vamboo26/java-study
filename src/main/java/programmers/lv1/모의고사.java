package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

    private static int[] secondSheet = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] thirdSheet = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            if(i % 5 + 1 == answer) {
                first++;
            }

            if(secondSheet[i % 8] == answer) {
                second++;
            }

            if(thirdSheet[i % 10] == answer) {
                third++;
            }
        }

        int max = Math.max(Math.max(first, second), third);

        List<Integer> result = new ArrayList<>();
        if(max == first) {
            result.add(1);
        }
        if(max == second) {
            result.add(2);
        }
        if(max == third) {
            result.add(3);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
