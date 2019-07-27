package programmers.kakao;

import org.junit.Test;

import java.util.*;

public class MujisMukBang2 {

    //마지막에 사이클 돌고 K번째 음식이 무엇인지 찾기 위해
    //N루프돌면서 찾는것보다
    //애초에 인덱스를 가진 푸드 리스트를 재가공하여
    //남아있는 리스트 중 K번째인 음식의 인덱스를 반환하는 게...
    //빠르긴한데 더 좋은방법인걸까?
    //빠르다 = 좋을지 고민
    //읽기좋은 방향은 어느쪽인지 고민

    private class Food {
        int id;
        int time;

        private Food(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public int solution(int[] food_times, long k) {
        if(!isValid(food_times, k)) {
            return -1;
        }

        List<Food> foods = new ArrayList<>();
        int curLength = food_times.length;


        for (int i = 0; i < curLength; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }

        foods.sort(Comparator.comparingInt(a -> a.time));

        long afterStopSec = k;
        int curId = 0;
        int answer = -1;
        int eatenFoodTimes = 0;

        for (Food f : foods) {
            int curFood = f.time - eatenFoodTimes;
            long tmp = (long) curLength * curFood;

            if(afterStopSec >= tmp) {
                afterStopSec -= tmp;
                eatenFoodTimes += curFood;
            } else {
                List<Food> subList = foods.subList(curId, food_times.length);
                subList.sort(Comparator.comparingInt(a -> a.id));
                answer = subList.get((int) (afterStopSec % curLength)).id;
                break;
            }


            curLength--;
            curId++;
        }

        return answer;
    }

    private boolean isValid(int[] arr, long k) {
        long temp = 0;
        for (int i : arr) {
            temp += i;
        }
        return temp > k;
    }

    @Test
    public void test() {
        int[] foodTimes = {3,1,2};
        System.out.println(solution(foodTimes, 5));
    }

}

