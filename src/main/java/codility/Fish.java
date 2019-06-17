package codility;

import org.junit.Test;

import java.util.Stack;

public class Fish {

    //TODO
    // googled https://stroot.tistory.com/105
    public int solution(int[] A, int[] B) {
        int aliveCount = 0;
        Stack<Integer> downFishes = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) {    // up fish
                aliveCount++;

                if (downFishes.isEmpty()) {
                    continue;
                }

                int downFish = downFishes.peek();

                while (true) {
                    aliveCount--;

                    if (A[downFish] < A[i]) {
                        downFishes.pop();

                        if (downFishes.isEmpty()) {
                            break;
                        }

                        downFish = downFishes.peek();
                    }
                    else {
                        break;
                    }
                }
            }
            else {    // down fish
                downFishes.add(i);
                aliveCount++;
            }
        }

        return aliveCount;
    }

    @Test
    public void test() {
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        System.out.println(solution(A,B));
    }

}
