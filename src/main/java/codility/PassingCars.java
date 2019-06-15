package codility;

public class PassingCars {

    public int solution(int[] A) {
        int sum = 0;
        int countOfWest = 0;

        for (int i : A) {
            if(i == 1) {
                countOfWest++;
            }
        }

        for (int i : A) {
            if (i == 0) {
                sum += countOfWest;
            } else {
                countOfWest--;
            }

            if(sum > 1_000_000_000) {
                return -1;
            }
        }

        return sum;
    }

}
