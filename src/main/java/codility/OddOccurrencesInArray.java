package codility;

import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * intstream -> stream (boxed()) 안해서 groupingby를 제대로 못써서 헤맸음!
 * 정확도100, 퍼포먼스 75로 88점
 * 스트림써서 느린가?
 * O(N) or O(N*log(N))
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        return Arrays
                .stream(A)
                .boxed()
                .collect(groupingBy(i -> i, counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() % 2 != 0)
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getKey();
    }

    /**
     * O(N**2)
     * 퍼포먼스 25, 총점 66
     */

    public int solution2(int[] A) {
        Queue<Integer> temp = new LinkedList<>();

        for (int each : A) {
            if(temp.contains(each)) {
                temp.remove(each);
                continue;
            }
            temp.add(each);
        }

        return temp.poll();
    }

    //O(N) or O(N*log(N))
    //하던대로하자...쓸데없이스트림 groupingby쓰지말고
    public int solution3(int[] A) {
        Set<Integer> result = new HashSet<>();
        for (int each : A) {
            if(result.contains(each)) {
               result.remove(each);
            } else {
                result.add(each);
            }
        }

        return result.iterator().next();
    }

    //TODO googled, 비트연산자 풀이, 짱짱, 비트연산자 다시 공부하기
    //https://hojak99.tistory.com/314
    public int solution4(int[] A) {
        int result = 0;

        for (int each : A) {
            result ^= each;
        }

        return result;
    }


    @Test
    public void test() {
    }

}
