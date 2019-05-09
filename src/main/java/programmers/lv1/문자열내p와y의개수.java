package programmers.lv1;

public class 문자열내p와y의개수 {

    boolean solution(String s) {
        s = s.toLowerCase().replaceAll("[^y | p]+" , "");
        return s.chars().filter(c -> c == 'p').count() * 2 == s.length();
    }

}
