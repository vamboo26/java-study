package programmers.lv2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class H인덱스 {

    public int solution(int[] citations) {
        List<Integer> temp = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < temp.size(); i++) {
            if(i >= temp.get(i)) {
                return i;
            }
        }

        return temp.size();
    }

    @Test
    public void test() {
        int[] citations = {3, 0, 6, 1, 5};
        solution(citations);
    }

}
