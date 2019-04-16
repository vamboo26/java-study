package programmers.lv2;

import java.util.*;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Feature> workspace = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            workspace.add(new Feature(progresses[i], speeds[i]));
        }

        int date = 0;
        List<Integer> deployRecord = new ArrayList<>();

        while (!workspace.isEmpty()) {
            date++;
            int works = 0;

            while (!workspace.isEmpty() && workspace.peek().isDeployable(date)) {
                workspace.poll();
                works++;
            }

            if (works != 0) {
                deployRecord.add(works);
            }
        }

        return deployRecord.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Feature {
        int progress;
        int speed;

        Feature(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        boolean isDeployable(int date) {
            return progress + date * speed >= 100;
        }
    }

    public int[] 참고풀이(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
    }
}
