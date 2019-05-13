package programmers.lv2;

import org.junit.Test;

import java.util.Stack;

public class 짝지어제거하기 {

    public int solution(String s) {
        Stack<Character> chars = new Stack<>();

        for (char c : s.toCharArray()) {
            add(chars, c);
        }

        return chars.size() == 0 ? 1 : 0;
    }

    private void add(Stack<Character> chars, Character c) {
        if(chars.size() > 0 && chars.peek() == c) {
            chars.pop();
            return;
        }

        chars.push(c);
    }

    @Test
    public void test() {
        String s = "hello";
    }

}
