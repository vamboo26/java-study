package programmers.lv2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<>();
        for(String[] each : clothes) {
            closet.put(each[1], closet.getOrDefault(each[1], 0) + 1);
        }

        int answer = 1;
        for(Integer value : closet.values()) {
            answer *= value + 1;
        }

        return answer - 1;
    }

    @Test
    public void test() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

}
