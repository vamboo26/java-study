package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        Set<String> selected = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if(selected.contains(words[i]) ||
                    (i > 0 && !words[i].startsWith(words[i - 1].substring(words[i - 1].length() - 1)))) {
                return new int[]{i % n + 1, i / n  + 1};
            }

            selected.add(words[i]);
        }

        return new int[]{0, 0};
    }

}
