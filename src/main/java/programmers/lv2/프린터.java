package programmers.lv2;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class 프린터 {
    //우선순위 큐 안쓰고, 배열 sort해서 로직에 쓰면 더 효율적일까?

    public int solution(int[] priorities, int location) {
        List<Integer> temp = new ArrayList<>();
        for (int priority : priorities) {
            temp.add(priority);
        }

        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            desc.add(priority);
        }

        int index = 0;

        while(location >= 0) {
            int head = temp.remove(0);

            if(head >= desc.peek()) {
                desc.poll();
                index++;
            } else {
                temp.add(head);

                if(location == 0) {
                    location += temp.size();
                }
            }

            location--;
        }

        return index;
    }

    @Test
    public void test() {
        int[] prio = {1, 1, 9, 1, 1, 1};
        int location = 0;
        assertEquals(solution(prio, location), 5);
    }
}
