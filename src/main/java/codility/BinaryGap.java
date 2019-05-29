package codility;

import org.junit.Test;

//20min
public class BinaryGap {

    public int solution(int N) {
        return process(Integer.toBinaryString(N), 0);
    }

    private int process(String str, int max) {
        int left = str.indexOf("1");
        int right = str.substring(left + 1).indexOf("1");

        //TODO 처음에 right <= 0으로 해서 66점, < 0 으로 100점
        if(right < 0) {
            return max;
        }

        return process(str.substring(left + 1 + right), Math.max(max, right));
    }

    @Test
    public void test() {
        System.out.println(solution(51712));
    }

}
