package programmers.lv3;

import org.junit.Test;

import java.util.Arrays;

public class 단어변환 {
    private static int length;
    private static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        if(Arrays.stream(words).noneMatch(word -> word.equals(target))) {
            return 0;
        }

        length = begin.length();
        char[] beginChar = begin.toCharArray();
        char[] targetChar = target.toCharArray();
        char[][] wordsChar = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            wordsChar[i] = words[i].toCharArray();
        }

        while(!Arrays.equals(beginChar, targetChar)) {
            for (int i = 0; i < wordsChar.length; i++) {
                if(wordsChar[i] == null) {
                    continue;
                }

                if(verifiedConversion(beginChar, targetChar)) {
                    return ++answer;
                }

                if (verifiedConversion(beginChar, wordsChar[i])) {
                    answer++;
                    beginChar = wordsChar[i];
                    wordsChar[i] = null;
                }
            }
        }

        return answer;
    }

    private boolean verifiedConversion(char[] begins, char[] letter) {
        int count = 0;

        for (int i = 0; i < length; i++) {
            if(begins[i] == letter[i]) {
                count++;
            }
        }

        return count == length - 1;
    }

    @Test
    public void test() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        solution(begin, target, words);
    }

}
