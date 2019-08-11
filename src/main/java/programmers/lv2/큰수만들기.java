package programmers.lv2;

import java.util.Stack;

public class 큰수만들기 {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for(int i = 0; i + 1 < sb.length() && k > 0; i++) {
            if(sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                i = -1;
                k--;
            }
        }

        if(k != 0) {
            sb.delete(sb.length() - k, sb.length());
        }

        return sb.toString();
    }

    public String solution2(String number, int k) {
        int targetLength = number.length() - k;

        Stack<Character> letters = new Stack<>();
        for(char c : number.toCharArray()) {
            while(!letters.isEmpty() && k-- > 0 && letters.peek() < c) {
                letters.pop();
            }

            letters.push(c);
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < targetLength; i++) {
            answer.append(letters.get(i));
        }

        return answer.toString();
    }

    //StringBuilder 대신 char 배열 길이만큼 선언 후 new String(char배열)도 가능

}
