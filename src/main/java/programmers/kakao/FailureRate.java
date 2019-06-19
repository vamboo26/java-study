package programmers.kakao;

import java.util.*;

//12:55 ~ 13:22, 리팩토링X, 성능고려X, 27분
public class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] currentUsersOfStage = new int[N + 2];
        for (int stage : stages) {
            currentUsersOfStage[stage]++;
        }

        List<Stage> data = new ArrayList<>();
        int accumulatedUsers = currentUsersOfStage[N + 1];

        for (int i = N; i > 0; i--) {
            accumulatedUsers += currentUsersOfStage[i];

            if(accumulatedUsers == 0) {
                data.add(new Stage(i, 0));
            } else {
                data.add(new Stage(i, (double) currentUsersOfStage[i] / accumulatedUsers));
            }
        }

        return data.stream().sorted().mapToInt(Stage::getIndex).toArray();
    }

    class Stage implements Comparable<Stage> {
        private int index;
        private double failureRate;

        Stage(int index, double failureRate) {
            this.index = index;
            this.failureRate = failureRate;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Stage o) {
            int result = -Double.compare(this.failureRate, o.failureRate);

            if(result == 0) {
                result = Integer.compare(this.index, o.index);
            }

            return result;
        }
    }

}