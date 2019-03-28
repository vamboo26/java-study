package programmers.lv2;

public class 타겟넘버 {
    private static int answer = 0;

    //TODO : Googled solution
    public int solution(int[] numbers, int target) {
        findTarget(numbers, target, 0);
        return answer;
    }

    private void findTarget(int[] numbers, int target, int depth) {
        if(depth == numbers.length) {
            int sum = 0;

            for (int number : numbers) {
                sum += number;
            }

            if(sum == target) {
                answer++;
            }

            return;
        }

        numbers[depth] *= 1;
        findTarget(numbers, target, depth + 1);

        numbers[depth] *= -1;
        findTarget(numbers, target, depth + 1);
    }
}
