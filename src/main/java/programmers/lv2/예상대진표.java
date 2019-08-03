package programmers.lv2;

public class 예상대진표 {

    public int solution(int n, int a, int b) {
        int round = 1;

        while(Math.abs(a - b) != 1 || Math.max(a, b) % 2 != 0) {
            a = (a - 1) / 2 + 1;
            b = (b - 1) / 2 + 1;
            round++;
        }

        return round;
    }

}
