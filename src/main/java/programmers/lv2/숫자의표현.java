package programmers.lv2;

public class 숫자의표현 {

    public int solution(int n) {
        int answer = 1;
        int half = n / 2;

        for (int i = 1; i < half + 1; i++) {
            int sum = 0;
            int start = i;

            while(sum < n) {
                sum += start;
                start++;
            }

            if(sum == n) {
                answer++;
            }
        }

        return answer;
    }

    /*
    주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리 <- ?
     */

    public int solution2(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) {
                answer++;
            }
        }

        return answer;
    }

}
