package programmers.lv2;

public class 일이사나라 {

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n % 3 == 0) {
                sb.insert(0, "4");
                n--;
            } else {
                sb.insert(0, n % 3);
            }

            n /= 3;
        }

        return sb.toString();
    }

}
