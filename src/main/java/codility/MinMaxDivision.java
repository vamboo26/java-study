package codility;

import org.junit.Test;

import java.util.*;

public class MinMaxDivision {

    //1st try, 35min 못품
    public int solution(int K, int M, int[] A) {
//        // write your code in Java SE 8
//
//        //A는 비지않은 배열, 모든 원소가 M보다 작다
//        //K개의 블럭으로 원소들을 분류해야해
//        //케이스당 각 블럭 내부의 합산 중 가장 큰게 largeSum
//        //케이스들 중에서 최소의 largeSum을 반환해라
//
//        //N and K are integers within the range [1..100,000];
//        //M is an integer within the range [0..10,000];
//        //each element of array A is an integer within the range [0..M].
//
//        //원소의 최대값이 M인 A배열을 K개의 블럭으로 나눌 때, 케이스의 largeSum이 최소인 경우는?
//
//        int sum = Arrays.stream(A).sum();
//        Arrays.sort(A);
//        int pivot = sum / K;
//
//        if(M == 0) {
//            return 0;
//        }
//
//        LinkedList<Integer> elements = new LinkedList<>();
//        for (int each : A) {
//            elements.add(each);
//        }
//
//        Collections.sort(elements);
//
//        int result = 0;
//
//        while(!elements.isEmpty()) {
//            int temp = 0;
//            temp += elements.removeLast();
//
//            while(!elements.isEmpty() && M - temp > elements.getFirst()) {
//                temp += elements.removeLast();
//            }
//
//            while(!elements.isEmpty() && pivot >= temp) {
//                temp += elements.removeFirst();
//            }
//
//            result = Math.max(result, temp);
//        }
//
//        return result;

        return 0;
    }

    //TODO Googled! O(N*log(N+M))
    // https://github.com/charles-wangkai/codility/blob/master/MinMaxDivision.java
    public int solution2(int K, int M, int[] A) {
        int result = -1;
        int upper = sum(A);
        int lower = max(A);

        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (countBlocks(A, middle) <= K) {
                result = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return result;
    }

    int max(int[] A) {
        int result = Integer.MIN_VALUE;
        for (int number : A) {
            result = Math.max(result, number);
        }
        return result;
    }

    int sum(int[] A) {
        int result = 0;
        for (int number : A) {
            result += number;
        }
        return result;
    }

    int countBlocks(int[] A, int largeSum) {
        int blockNum = 1;
        int remain = largeSum;
        for (int number : A) {
            if (remain < number) {
                remain = largeSum;
                blockNum++;
            }
            remain -= number;
        }

        return blockNum;
    }

    @Test
    public void test() {
        int K = 3;
        int M = 5;
        int[] A = {2,1,5,1,2,2,2};

        System.out.println(solution2(K, M, A));
    }

}
