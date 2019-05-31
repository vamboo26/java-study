package codility;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

//14min, 정확도만 87점
//TODO empty array에 대해서 런타임에러(예외처리 부재)
//N and K are integers within the range [0..100];
//N은 원소의 개수인데 N이 0도 가능하니까 빈 배열도 가능한테 체크못했음!!
//문제꼼꼼히

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        return swap(A, K);
    }

    private int[] swap(int[] arr, int distance) {
        if(arr.length == 0) {
            return new int[0];
        }

        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[(i + distance) % arr.length] = copy[i];
        }

        return arr;
    }

    //googled
    //그냥 리스트쓰면 이렇게? https://github.com/prostars/codility/blob/master/src/Lesson_2/CyclicRotation.java
    public static int[] solution2(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0)
            return A;

        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

        for (int i = 0; i < K; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    @Test
    public void test() {
        int[] A = {3,8,9,7,6};
        int[] B = {};
        int K = 3;
        System.out.println(Arrays.toString(solution(B, K)));

        int[] x = new int[]{};
        int[] y = new int[0];

        swap(x, 3);

        assertThat(x).isEqualTo(y);
    }

}
