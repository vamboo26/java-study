package etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고 아래 문제에 대한 프로그램을 작성하세요.
 * 이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌
 * 김씨와 이씨는 각각 몇 명 인가요?
 * "이재영"이란 이름이 몇 번 반복되나요?
 * 중복을 제거한 이름을 출력하세요.
 * 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.
 */

public class Q1 {

    private static final String str = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";

    static void solution(String str) {
        String[] splited = str.split(",");

        System.out.println(Arrays.stream(splited)
                .filter(i -> i.startsWith("김"))
                .count());

        System.out.println(Arrays.stream(splited)
                .filter(i -> i.startsWith("이"))
                .count());

        System.out.println(Arrays.stream(splited)
                .filter(i -> i.equals("이재영"))
                .count());

        Set<String> temp = new HashSet<>();
        Set<String> duplicated = new HashSet<>();
        for (String each : splited) {
            if(temp.contains(each)) {
                duplicated.add(each);
            }

            temp.add(each);
        }

        System.out.println(duplicated);
        System.out.println("-----------------");
        temp.stream().sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        solution(str);
    }
}
