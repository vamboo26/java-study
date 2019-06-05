package etc.test;

public class ECTEST {

    public int solution(String plain) {
        int length = plain.length();

        for (int i = 0; i < length; i++) {
            if(isPalindrome(plain.substring(i))) {
                return length + i;
            }
        }

        return 0;
    }

    private boolean isPalindrome(String str) {
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if(str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}
