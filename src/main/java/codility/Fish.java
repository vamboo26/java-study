package codility;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        int count = 0;
        Stack<Integer> downForwardFishes = new Stack<>();

        for (int i = 0; i < B.length; i++) {
            count++;
            int direction = B[i];

            if(direction == 1) {
                downForwardFishes.add(A[i]);
            }

            if(direction == 0) {
                int P = downForwardFishes.pop();

                while(!downForwardFishes.isEmpty() && i < B.length - 1) {
                    int Q = A[i + 1];

                    if(P > Q) {
                        downForwardFishes.add(P);
                    }

                    if(Q > P) {
                        break;
                    }

                    i++;
                }
            }
        }

        return count;
    }

}
