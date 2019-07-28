package programmers.lv2;

import org.junit.Test;

import java.util.*;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            String target = phone_book[i];

            for (int j = i + 1; j < phone_book.length; j++) {
                if (target.startsWith(phone_book[j]) || phone_book[j].startsWith(target)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean 참고할만한풀이(String[] phoneBook) {
        Arrays.sort(phoneBook); //string 정렬의 성격을 이용

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].contains(phoneBook[i])) {
                return false;
            }
        }

        return true;
    }

}
