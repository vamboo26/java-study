package programmers.lv2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 가장큰수 {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        list.sort((a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }

        String answer;
        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }

    public String solution2(int[] numbers) {
        String[] s = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            s[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.charAt(0) == b.charAt(0)) {
                    int aa = Integer.parseInt(a + b);
                    int bb = Integer.parseInt(b + a);
                    return bb - aa;
                }

                return b.charAt(0) - a.charAt(0);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String value : s) {
            sb.append(value);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }


    @Test
    public void test() {
        int[] numbers = {3, 30, 34, 5, 9};
        assertThat(solution(numbers)).isEqualTo("9534330");
    }
}
