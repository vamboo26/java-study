package codility;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {

    public int solution(int[] A) {
        Set<Integer> elements = new HashSet<>();
        for (int each : A) {
            elements.add(each);
        }

        for (Integer element : elements) {
            if(!elements.contains(element + 1) && element != elements.size() + 1) {
                return element + 1;
            }
        }

        return 1;
    }

}
