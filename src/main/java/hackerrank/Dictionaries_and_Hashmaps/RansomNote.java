package hackerrank.Dictionaries_and_Hashmaps;

import java.util.Arrays;
import java.util.LinkedList;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        LinkedList<String> wordBundle = new LinkedList<>(Arrays.asList(magazine));
        for (String word : note) {
            if(!wordBundle.remove(word)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};

        checkMagazine(magazine, note);
    }

}
