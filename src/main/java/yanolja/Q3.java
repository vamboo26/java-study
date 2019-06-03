package yanolja;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {

    private static final int LIMIT_OF_ELEMENTS = 100_000;

    public int solution(int[] ranks) {
        int result = 0;
        Set<Integer> existRanks = new HashSet<>();
        int[] countOfSoldiers = new int[LIMIT_OF_ELEMENTS + 1];

        countSoldiers(ranks, existRanks, countOfSoldiers);
        return countReports(result, existRanks, countOfSoldiers);
    }

    private void countSoldiers(int[] ranks, Set<Integer> existRanks, int[] countOfSoldiers) {
        for (int eachRank : ranks) {
            existRanks.add(eachRank);
            countOfSoldiers[eachRank]++;
        }
    }

    private int countReports(int result, Set<Integer> existRanks, int[] countOfSoldiers) {
        for (Integer rank : existRanks) {
            if(existRanks.contains(rank + 1)) {
                result += countOfSoldiers[rank];
            }
        }

        return result;
    }

    public int solution2(int[] ranks) {
        int result = 0;
        Map<Integer, Integer> soldiers = new HashMap<>();

        for (int each : ranks) {
            if(!soldiers.containsKey(each)) {
                soldiers.put(each, 1);
            } else {
                soldiers.put(each, soldiers.get(each) + 1);
            }
        }

        for (Integer eachKey : soldiers.keySet()) {
            if(soldiers.containsKey(eachKey + 1)) {
                result += soldiers.get(eachKey);
            }
        }

        return result;
    }



    @Test
    public void test() {
        System.out.println(solution(new int[]{4,2,0}));
        System.out.println(solution(new int[]{4,4,3,3,1,0}));
        System.out.println(solution(new int[]{3,4,3,0,2,2,3,0,0}));
        System.out.println(solution(new int[]{0,10000}));
        System.out.println(solution(new int[]{0,0,0,1}));
        System.out.println(solution(new int[]{0,0,0,1,2,2,2,2,4,5,5,5}));
    }

}
