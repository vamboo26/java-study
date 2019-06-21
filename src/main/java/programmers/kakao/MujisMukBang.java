package programmers.kakao;

import org.junit.Test;

import java.util.*;

//효율성 케이스 3개 실패!
//NavigableMap 쓸모없어서 Hash로 바꿨더니 케이스 1개만 실패!
//맵에 담는 로직에서 getOrDefault썼더니 통과!(기존에는 contains로 확인헀음)
//https://programmers.co.kr/learn/courses/30/lessons/42891/solution_groups?language=java
//효율성에서 많이 부족해보임
//마지막에 인덱스 구할 때 food_times의 요소가 많으면 많을수록 불리해지는듯
//아예 리스트로 필터링해서 인덱스를 구하는 식이 나을까? food 객체 빼서 해보기

public class MujisMukBang {

    public int solution(int[] food_times, long k) {
        if(!isValid(food_times, k)) {
            return -1;
        }

        Map<Integer, Integer> timeMap = new HashMap<>();
        for (int food_time : food_times) {
            timeMap.put(food_time, timeMap.getOrDefault(food_time, 0) + 1);
        }

        int cycle = 0;
        int cycleRange = food_times.length;

        while(k >= cycleRange) {
            k -= cycleRange;
            cycle++;

            if(timeMap.containsKey(cycle)) {
                cycleRange -= timeMap.get(cycle);
            }
        }

        for (int i = 0; i < food_times.length; i++) {
            if(food_times[i] - cycle > 0) {
                k--;
            }

            if(k < 0) {
                return i + 1;
            }
        }

        return -1;
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

