package programmers.kakao;

import java.util.*;

//12:55 ~ 13:22, 리팩토링X, 성능고려X, 27분
public class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] usersOfStage = new int[N + 2];
        for (int stage : stages) {
            usersOfStage[stage]++;
        }


        List<Stage> data = new ArrayList<>();
        int accumulatedUsers = usersOfStage[N + 1];

        for (int i = N; i > 0; i--) {
            accumulatedUsers += usersOfStage[i];

            if(accumulatedUsers == 0) {
                data.add(new Stage(i, 0));
            } else {
                data.add(new Stage(i, (double) usersOfStage[i] / accumulatedUsers));
            }
        }


        Collections.sort(data);

        return data.stream().mapToInt(i -> i.index).toArray();
    }

    class Stage implements Comparable<Stage> {

        private int index;
        private double failureRate;

        public Stage(int index, double failureRate) {
            this.index = index;
            this.failureRate = failureRate;
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


/*
테스트 1 〉	통과 (5.04ms, 48.3MB)
테스트 2 〉	통과 (8.34ms, 48.6MB)
테스트 3 〉	통과 (11.94ms, 48.9MB)
테스트 4 〉	통과 (11.75ms, 53.2MB)
테스트 5 〉	통과 (15.37ms, 59.7MB)
테스트 6 〉	통과 (5.87ms, 48.4MB)
테스트 7 〉	통과 (6.15ms, 48.6MB)
테스트 8 〉	통과 (8.11ms, 53.4MB)
테스트 9 〉	통과 (15.47ms, 59.6MB)
테스트 10 〉	통과 (9.33ms, 52.4MB)
테스트 11 〉	통과 (15.09ms, 52.7MB)
테스트 12 〉	통과 (8.56ms, 56.4MB)
테스트 13 〉	통과 (9.40ms, 57.4MB)
테스트 14 〉	통과 (6.37ms, 48.3MB)
테스트 15 〉	통과 (11.59ms, 52.1MB)
테스트 16 〉	통과 (6.69ms, 48.9MB)
테스트 17 〉	통과 (7.80ms, 50.7MB)
테스트 18 〉	통과 (6.88ms, 48.7MB)
테스트 19 〉	통과 (5.21ms, 48.8MB)
테스트 20 〉	통과 (7.35ms, 50.5MB)
테스트 21 〉	통과 (8.63ms, 50.7MB)
테스트 22 〉	통과 (9.89ms, 58.8MB)
테스트 23 〉	통과 (8.57ms, 57.1MB)
테스트 24 〉	통과 (8.77ms, 56.6MB)
테스트 25 〉	통과 (4.80ms, 48.6MB)
테스트 26 〉	통과 (4.54ms, 48.3MB)
테스트 27 〉	통과 (4.46ms, 47.9MB)
 */