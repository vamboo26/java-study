package programmers.lv2;

public class 카펫 {

    public int[] solution(int brown, int red) {
        int sum = (brown - 4) / 2;

        for (int i = 1; i < sum; i++) {
            int j = sum - i;

            if (i + j == sum && i * j == red) {
                return new int[]{j + 2, i + 2};
            }
        }

        return null;
    }

    public int[] 참고풀이(int brown, int red) {
        for (int i = 1; i <= red; i++) {
            if (red % i == 0 && (red / i + i) * 2 + 4 == brown) {
                return new int[]{red / i + 2, i + 2};
            }
        }
        return null;
    }

}
