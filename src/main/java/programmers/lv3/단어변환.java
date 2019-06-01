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


    public int solution2(String begin, String target, String[] words) {
        int answer = 0;
        // 워드스랑 비교

        boolean[] isVisited = new boolean[words.length];
        answer = dfs(begin, target, words, 0, isVisited, " ");
        System.out.println(answer);


        if (answer == 99) {
            return 0;
        }

        return answer;
    }

    // length 값까지 근대 넘으면 99;
    private int dfs(String begin, String target, String[] words, int count, boolean[] isVisited, String history) {
        if (begin.equals(target)) {
            System.out.println("결론 히스토리: " + history);
            System.out.println("결론이 났따. " + count + begin);
            return count;
        }

        if (count > words.length) {
            return 99;
        }

        int answer = 99;

        for (int i = 0; i < words.length; i++) {
            if (!begin.equals(words[i])) {
                if (onlyOneThingIsWrong(begin, words[i])) {
                    int newAnswer = dfs(words[i], target, words, count + 1, isVisited, history + words[i]);
                    answer = newAnswer < answer ? newAnswer : answer;
                }
            }

        }

        System.out.println("히스토리 : " + history);
        return answer;
    }

    private boolean onlyOneThingIsWrong(String begin, String word) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        solution(begin, target, words);
    }

}
