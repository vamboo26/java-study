package programmers.lv2;

public class 점프와순간이동 {

    public int solution(int n) {
        int answer = 0;

        while(n != 0) {
            if(n % 2 != 0) {
                answer++;
                n--;
            }

            n /= 2;
        }

        return answer;
    }

}
