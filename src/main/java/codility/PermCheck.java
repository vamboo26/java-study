package codility;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();
        for (int each : A) {
            numbers.add(each);
        }

        for (int i = 1; i <= A.length; i++) {
            if(!numbers.contains(i)) {
                return 0;
            }
        }

        return 1;
    }

}
