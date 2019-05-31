package codility;

import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;

public class MaxNonoverlappingSegments {

    //10min, 0점!
//    public int solution(int[] A, int[] B) {
//        int maximumSegments = 0;
//
//        for (int i = 0; i < A.length; i++) {
//            int currentSegments = 1;
//            int lastPoint = B[i];
//
//            for (int j = i + 1; j < A.length; j++) {
//                if(lastPoint < A[j]) {
//                    currentSegments++;
//                } else {
//                    lastPoint = B[j];
//                }
//            }
//
//            maximumSegments = Math.max(maximumSegments, currentSegments);
//        }
//
//        return maximumSegments;
//    }

    //TODO
    // googled 그냥 모든 segment의 높낮이를 생각하지말고 바닥에 깔아서 한줄로 긋는다고 생각하면 됨
    // 어차피 겹친 segment는 하나로 보는 경우밖에 없음 O(N)
    public int solution2(int[] A, int[] B) {
        int numberOfSegments = A.length;

        if (numberOfSegments <= 1) {
            return numberOfSegments;
        }

        int count = 1;
        int previousEndPoint = B[0];

        for (int i = 0; i < numberOfSegments; i++) {
            if(A[i] > previousEndPoint) {
                count++;
                previousEndPoint = B[i];
            }
        }

        return count;
    }

}
