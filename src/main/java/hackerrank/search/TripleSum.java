package hackerrank.search;

import org.junit.Test;

import java.util.Arrays;

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {
        int[] sortedSetA = getUniqueAndSorted(a);
        int[] sortedSetB = getUniqueAndSorted(b);
        int[] sortedSetC = getUniqueAndSorted(c);

        long result = 0;
        for (int numberB : sortedSetB) {
            result += (long) numberOfTargets(sortedSetA, numberB) * numberOfTargets(sortedSetC, numberB);
        }

        return result;
    }

    static int numberOfTargets(int[] x, int number) {
        int index = Arrays.binarySearch(x, number);
        if (index < 0) {
            return -index - 1;
        }
        return index + 1;
    }

    static int[] getUniqueAndSorted(int[] x) {
        return Arrays.stream(x).distinct().sorted().toArray();
    }

    @Test
    public void test() {
        int[] a = {1,3,5,7};
        int[] b = {4,7,9};
        int[] c = {7,9,11,13};

        System.out.println(triplets(a,b,c));
    }
}
