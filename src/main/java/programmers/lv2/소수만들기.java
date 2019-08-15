package programmers.lv2;

public class 소수만들기 {

    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int target = nums[i] + nums[j] + nums[k];
                    if(isPrime(target)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPrime(int target) {
        for(int i = 2; i * i <= target; i++) {
            if(target % i == 0) {
                return false;
            }
        }

        return true;
    }

}
