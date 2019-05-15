package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class BUD {

    public static void main(String[] args) {
        int[] first = {1,5,12,3,-15,52};
        int[] second = {3,1,6,5,57,13,17};

        //find elements in common

        //1. brute force O(A*B)
        //B -> bottleneck, contains(..) is O(B)
        //* use hashset for O(A+B) algorithm

        //O(A+B)
        Set<Integer> key = new HashSet<>();
        for (int i : first) {
            key.add(i);
        }

        for (int i : second) {
            if(key.contains(i)) {
                System.out.println(i);
            }
        }

        //O(A*B)
        for (int i : first) {
            for (int j : second) {
                if(i == j) {
                    System.out.println(i);
                }
            }
        }



        String s = "xacxzaa";
        String b = "fxaazxacaaxzoecazxaxaz";
        //Find all permutations of s within b
        //O(b) ~ O(s^2*b)

        int target = s.chars().sum();

        for (int i = 0; i < b.length() - 7; i++) {
            String extracted = b.substring(i, i + 7);
            if(extracted.chars().sum() == target) {
                System.out.println(extracted);
            }
        }

        //https://stackoverflow.com/questions/41515081/algorithm-find-all-permutations-of-string-a-in-string-b
    }

}
