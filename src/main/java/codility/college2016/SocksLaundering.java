package codility.college2016;

import org.junit.Test;

import java.util.*;

public class SocksLaundering {

    /**
     * In your solution, focus on correctness.
     * The performance of your solution will not be the focus of the assessment.
     */

    //12min, 코드가 너무 더럽다, 정확성에 초점을 두라고 한 문제긴한데, 근데 정확도도 30점이네;;ㅋ
//    public int solution(int K, int[] C, int[] D) {
//        Queue<Integer> pairs = new LinkedList<>();
//        List<Integer> dirtySocks = new ArrayList<>();
//        for (int i : D) {
//            dirtySocks.add(i);
//        }
//
//        int numberOfPairs = 0;
//
//        for (int each : C) {
//            if(pairs.contains(each)) {
//                pairs.remove(each);
//                numberOfPairs++;
//            } else {
//                pairs.add(each);
//            }
//        }
//
//        while(K > 0 && !pairs.isEmpty() && !dirtySocks.isEmpty()) {
//            int first = pairs.poll();
//            if(dirtySocks.contains(first)) {
//                dirtySocks.remove(first);
//                numberOfPairs++;
//            } else {
//                pairs.add(first);
//            }
//
//            K--;
//        }
//
//        return numberOfPairs;
//    }

    //20min? 100, 로직이 복잡한데 굳이...? 다른 풀이 없을까
    public int solution2(int K, int[] C, int[] D) {
        int numberOfPairs = 0;
        Queue<Integer> unmatchedCleanSocks = new PriorityQueue<>();
        Queue<Integer> dirtySocks = new PriorityQueue<>();

        //깨끗한 양말 중 pair를 골라낸다
        for (int each : C) {
            if (unmatchedCleanSocks.contains(each)) {
                unmatchedCleanSocks.remove(each);
                numberOfPairs++;
            } else {
                unmatchedCleanSocks.add(each);
            }
        }

        for (int each : D) {
            dirtySocks.add(each);
        }

        //깨끗한 양말 중 짝 없는 것들을 더러운 것들과 매치시켜 pair를 만든다
        while (K > 0 && !unmatchedCleanSocks.isEmpty()) {
            int unmatchedColor = unmatchedCleanSocks.poll();

            if (dirtySocks.contains(unmatchedColor)) {
                dirtySocks.remove(unmatchedColor);
                numberOfPairs++;
                K--;
            }
        }

        //여전히 K가 2 이상 남았다면 더러운 것들 중에서 pair를 만들어본다
        while (K > 1 && !dirtySocks.isEmpty()) {
            int unmatchedColor = dirtySocks.poll();

            if (dirtySocks.contains(unmatchedColor)) {
                dirtySocks.remove(unmatchedColor);
                numberOfPairs++;
                K -= 2;
            }
        }

        return numberOfPairs;
    }

}
