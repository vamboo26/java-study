package programmers.lv3;

public class 가장긴펠린드롬 {

    //참고풀인데 시간초과
    public int solution(String s) {
        return getPalindrom(s);
    }

    private int getPalindrom(String str) {
        if (str.equals(new StringBuilder(str).reverse().toString())) {
            return str.length();
        } else {
            int removeRightOne = getPalindrom(str.substring(0, str.length() - 1));
            int removeLeftOne = getPalindrom(str.substring(1));
            return Math.max(removeRightOne, removeLeftOne);
        }
    }

}