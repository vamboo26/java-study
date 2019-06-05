package etc.test.yaja;

import org.junit.Test;

public class Q2 {

    private static final int NUMBER_OF_SEASONS = 4;

    public String solution(int[] T) {
        int criteriaOfDivision = T.length / NUMBER_OF_SEASONS;
        int[][] result = new int[NUMBER_OF_SEASONS][2];

        for (int[] eachArr : result) {
            eachArr[0] = Integer.MAX_VALUE;
            eachArr[1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < T.length; i++) {
            int index = i / criteriaOfDivision;
            result[index][0] = Math.min(result[index][0], T[i]);
            result[index][1] = Math.max(result[index][1], T[i]);
        }

        int sequenceOfMostDistinguishingSeason = 0;
        int maxAmplitude = Integer.MIN_VALUE;

        for (int i = 0; i < NUMBER_OF_SEASONS; i++) {
            int amplitude = Math.abs(result[i][1] - result[i][0]);
            if(amplitude > maxAmplitude) {
                maxAmplitude = amplitude;
                sequenceOfMostDistinguishingSeason = i;
            }
        }

        for (Season value : Season.values()) {
            if(sequenceOfMostDistinguishingSeason == value.sequence) {
                return value. toString();
            }
        }

        return Season.getSeason(sequenceOfMostDistinguishingSeason);
    }

    public enum Season {
        WINTER(0),
        SPRING(1),
        SUMMER(2),
        AUTUMN(3);

        private int sequence;

        Season(int sequence) {
            this.sequence = sequence;
        }

        private static String getSeason(int sequence) {
            for (Season value : values()) {
                if(value.sequence == sequence) {
                    return value.toString();
                }
            }

            return null;
        }
    }

    @Test
    public void test() {
        System.out.println(solution(new int[]{-3,-14,-5,7,8,42,8,3}));
        System.out.println(solution(new int[]{2,-3,3,1,10,8,2,5,13,-5,3,18}));
        System.out.println(solution(new int[]{-1000,-999,-999,-997,8,42,8,3}));
        System.out.println(solution(new int[]{1000,2,3,5,1,6,2,12}));
        System.out.println(solution(new int[]{222,2,333,5,1,6,2,12}));
    }

}
