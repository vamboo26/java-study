package yaja;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q4 {

    private static final int MAX_RESULT = 1_000_000_000;
    private static final int LIMIT_OF_ELEMENTS = 100_000;

    public int solution(int[] A) {
        long result = 0;
        int[] countOfNumbers = new int[LIMIT_OF_ELEMENTS + 1];

        for (int each : A) {
            countOfNumbers[each]++;
        }

        for (int distributionOfNumber : countOfNumbers) {
            if (distributionOfNumber > 1) {
                result += getNumberOfPairs(distributionOfNumber);
            }
        }

        return result > MAX_RESULT
                ? MAX_RESULT
                : (int) result;
    }

    public int solution2(int[] A) {
        long result = 0;
        Map<Integer, Integer> numberOfElements = new HashMap<>();

        for (int each : A) {
            if(!numberOfElements.containsKey(each)) {
                numberOfElements.put(each, 1);
            } else {
                numberOfElements.put(each, numberOfElements.get(each) + 1);
            }
        }

        for (Integer eachKey : numberOfElements.keySet()) {
            int value = numberOfElements.get(eachKey);
            if(value > 1) {
                result += getNumberOfPairs(value);
            }
        }

        return result > MAX_RESULT
                ? MAX_RESULT
                : (int) result;
    }

    private long getNumberOfPairs(int count) {
        return (long) count * (count - 1) / 2;
    }

    @Test
    public void test() {
        int[] A = {3, 5, 6, 3, 3, 5, 10000};
        System.out.println(solution(A));
        System.out.println(solution2(new int[]{2,2,2,2,2,2}));
    }

}
