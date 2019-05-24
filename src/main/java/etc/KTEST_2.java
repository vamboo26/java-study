package etc;

import org.junit.Test;

public class KTEST_2 {
    //18분

    public String solution(String compressed) {
        return convert(compressed);
    }

    public String convert(String word) {
        if(!word.contains("(")) {
            return word;
        }

        int left = word.lastIndexOf('(');
        int right = left + word.substring(left).indexOf(')');
        int times = Integer.parseInt(word.substring(left - 1, left));

        StringBuilder sb = new StringBuilder();
        sb.append(word, 0, left - 1);
        for (int i = 0; i < times; i++) {
            sb.append(word, left + 1, right);
        }
        sb.append(word, right + 1, word.length());

        return convert(sb.toString());
    }

    @Test
    public void test() {
        String compressed = "2(2(hi)2(co))x2(bo)";
        System.out.println(solution(compressed));
    }
}
