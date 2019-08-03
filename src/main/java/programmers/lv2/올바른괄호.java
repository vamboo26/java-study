package programmers.lv2;

public class 올바른괄호 {

    boolean solution(String s) {
        int brackets = 0;

        for(char eachBracket : s.toCharArray()) {
            if(eachBracket == '(') {
                brackets++;
            } else {
                brackets--;
            }

            if(brackets < 0) {
                return false;
            }
        }

        return brackets == 0;
    }

}
