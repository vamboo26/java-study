package programmers.lv2;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 라면공장 {

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        List<Supply> supplyPlan = new ArrayList<>();
        for (int i = 0; i < dates.length; i++) {
            supplyPlan.add(new Supply(dates[i], supplies[i]));
        }

        while(stock < k) {
            int currentStock = stock;
            Supply supplied = Objects.requireNonNull(supplyPlan.stream()
                    .filter(i -> i.date <= currentStock)
                    .max(Comparator.comparing(Supply::getAmount))
                    .orElse(null));

            supplyPlan.remove(supplied);
            stock += supplied.amount;
            answer++;
        }

        return answer;
    }

    //TODO : Googled solution
    public int 참고풀이(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<Supply> supplyQueue = new PriorityQueue<>();
        for (int i = 0; i < supplies.length; i++) {
            supplyQueue.add(new Supply(dates[i], supplies[i]));
        }

        List<Supply> supplyPlan = new ArrayList<>();
        for (int i = 0; i < dates.length; i++) {
            supplyPlan.add(supplyQueue.poll());
        }

        while (stock < k) {
            for (int i = 0; i < supplyPlan.size(); i++) {
                if (stock >= supplyPlan.get(i).date) {
                    stock += supplyPlan.get(i).amount;
                    supplyPlan.remove(i);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    class Supply implements Comparable<Supply> {
        int date;
        int amount;

        Supply(int date, int amount) {
            this.date = date;
            this.amount = amount;
        }

        int getAmount() {
            return amount;
        }

        @Override
        public int compareTo(Supply target) {
            return this.amount > target.amount ? -1 : 1;
        }
    }

    @Test
    public void test () {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        assertThat(solution(stock, dates, supplies, k)).isEqualTo(2);
    }
}
