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
        if (right < 0) {
            return max;
        }

        return process(str.substring(left + 1 + right), Math.max(max, right));
    }

    //재귀는 시간복잡도에서... 그냥 반복을 도는 것도?
    // googled
    public static int solution2(int N) {
        String binaryNumber = Integer.toBinaryString(N);
        int len = binaryNumber.length();
        int maxCount = 0, count = 0;

        for (int idx = 0; idx < len; idx++) {
            if (binaryNumber.charAt(idx) == '1') {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            } else{
                count++;
            }
        }

        return maxCount;
    }

    @Test
    public void test() {
        System.out.println(solution(51712));
    }

}
