package codility;

import java.util.Stack;

public class Nesting {

    //O(N)
    public int solution(String S) {
        Stack<Character> brackets = new Stack<>();

        for (char eachChar : S.toCharArray()) {
            if(eachChar == ')') {
                if(brackets.isEmpty()) {
                    return 0;
                } else {
                    brackets.pop();
                }
            } else {
                brackets.push(eachChar);
            }
        }

        return brackets.isEmpty() ? 1 : 0;
    }

    //O(N) looks better
    public int solution2(String S) {
        int bracket = 0;

        for (char eachChar : S.toCharArray()) {
            if(eachChar == '(') {
                bracket++;
            } else {
                bracket--;
            }

            if(bracket < 0) {
                return 0;
            }
        }

        return bracket == 0 ? 1 : 0;
    }

}
