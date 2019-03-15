package programmers.lv2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 다리를지나는트럭 {
    //구글링해서 카피 후 리팩토링했는데 더 간결하게는 못하나?

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sec = 0;
        int crossing_weight = 0;

        Queue<Truck> waitingTrucks = new LinkedList<>();
        Queue<Truck> crossingTrucks = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            waitingTrucks.add(new Truck(truck_weight));
        }

        while (!waitingTrucks.isEmpty() || !crossingTrucks.isEmpty()) {
            sec++;

            if (crossingTrucks.isEmpty()) {
                Truck t = waitingTrucks.poll();
                crossing_weight += t.weight;
                crossingTrucks.offer(t);
                continue;
            }

            for (Truck t : crossingTrucks) {
                t.go();
            }

            if (crossingTrucks.peek().isArrived(bridge_length)) {
                Truck t = crossingTrucks.poll();
                crossing_weight -= t.weight;
            }

            if (!waitingTrucks.isEmpty() && crossing_weight + waitingTrucks.peek().weight <= weight) {
                Truck t = waitingTrucks.poll();
                crossing_weight += t.weight;
                crossingTrucks.offer(t);
            }
        }

        return sec;
    }

    class Truck {
        int position = 1;
        int weight;

        public Truck(int weight) {
            this.weight = weight;
        }

        public void go() {
            this.position++;
        }

        public boolean isArrived(int distance) {
            return position > distance;
        }
    }

    @Test
    public void test() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        assertThat(solution(bridge_length, weight, truck_weights)).isEqualTo(101);
    }
}
