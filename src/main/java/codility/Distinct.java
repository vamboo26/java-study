package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public int solution(int[] A) {

//        O(N*log(N)) or O(N) 퍼포먼스 100
        Set<Integer> distinctNumbers = new HashSet<>();
        for (int each : A) {
            distinctNumbers.add(each);
        }

        return distinctNumbers.size();


//        O(N*log(N)) or O(N) 퍼포먼스 66
//        return (int) Arrays.stream(A).distinct().count();
    }

}
