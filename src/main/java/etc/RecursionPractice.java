package etc;

import org.junit.Test;

import java.util.Scanner;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RecursionPractice {

    private int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private double gcd(int A, int B) {
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
        }

        if (A % B == 0) {
            return B;
        }

        return gcd(B, A % B);
    }

    private int simpleGcd(int A, int B) {
        if (B == 0) {
            return A;
        }

        return simpleGcd(B, A % B);
    }

    private int stringLength(String str) {
        if(str.equals("")) {
            return 0;
        }

        return 1 + stringLength(str.substring(1));
    }

    private void printChars(String str) {
        if(str.length() == 0) {
            return;
        }

        System.out.println(str.charAt(0));
        printChars(str.substring(1));
    }

    private void printReverseChard(String str) {
        if(str.length() == 0) {
            return;
        }

        printReverseChard(str.substring(1));
        System.out.println(str.charAt(0));
    }

    private void printInBinary(int n) {
        if(n < 2) {
            System.out.println(n);
            return;
        }

        printInBinary(n / 2);
        System.out.println(n % 2);
    }

    private int sum(int n, int[] data) {
        if(n <= 0) {
            return 0;
        }

        return sum(n - 1, data) + data[n - 1];
    }

    private void readForm(int n, int[] data, Scanner sc) {
        if(n == 0) {
            return;
        }

        readForm(n - 1, data, sc);
        data[n - 1] = sc.nextInt();
    }

    /*
    TODO in Recursion : 암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 바꿔라!
    크기 n인 배열을 순차 탐색한다고 할 때, [0] ~ [n - 1]을 탐색하는데 여기서 n - 1은 명시적,
    [0]은 암시적인 매개변수!!!

    일반적으로는 변수가 많아서 좋을 게 없으므로 암시적으로 생략하지만,
    Recursion에서는 일반적으로 명시적으로 표현하는 게 좋다.
     */

    private int generalSearch(int n, int[] data, int target) {
        for (int i = 0; i < n; i++) {
            if(data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //int begin으로 시작점을 '명시적'으로 지정
    //다시 자기자신을 호출할 때 필요한 변수까지 고려해야한다
    //만약 end나 begin 등이 변하지 않는 수라면 치환하여 불필요한 매개변수를 줄일 수 있다
    private int recursiveSearch(int[] data, int begin, int end, int target) {
        if(begin > end) {
            return -1;
        }

        if(data[begin] == target) {
            return begin;
        }

        return recursiveSearch(data, begin + 1, end, target);
    }

    private int recursiveSearch2(int[] data, int begin, int end, int target) {
        if(begin > end) {
            return -1;
        }

        int middle = (begin + end) / 2;

        if(data[middle] == target) {
            return middle;
        }

        int frontSearch = recursiveSearch2(data, begin, middle - 1, target);

        if(frontSearch != -1) {
            return frontSearch;
        }

        return recursiveSearch2(data, middle + 1, end, target);
    }

    private int findMax(int[] data, int begin, int end) {
        if(begin == end) {
            return data[begin];
        }

        return Math.max(data[begin], findMax(data, begin + 1, end));
    }

    private int findMax2(int[] data, int begin, int end) {
        if(begin == end) {
            return data[begin];
        }

        int middle = (begin + end) / 2;
        int frontMax = findMax2(data, begin, middle);
        int rearMax = findMax2(data, middle + 1, end);

        return Math.max(frontMax, rearMax);
    }

    private int binarySearch(String[] items, String target, int begin, int end) {
        if(begin > end) {
            return -1;
        }

        int middle = (begin + end) / 2;
        int result = items[middle].compareTo(target);

        if(result == 0) {
            return begin;
        }

        if(result > 0) {
            return binarySearch(items, target, begin, middle - 1);
        }

        return binarySearch(items, target, middle + 1, end);
    }

    private boolean findMazePath(int[][] maze, int x, int y) {
        if( x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }

    }

    @Test
    public void test() {
        System.out.println(fibonacci(14));
        System.out.println(gcd(12, 3));
        System.out.println(simpleGcd(12, 3));
        System.out.println(simpleGcd(3, 12));

        assertThat(stringLength("abcde")).isEqualTo(5);
        printChars("abcde");
        printReverseChard("abcde");
        printInBinary(10);
        assertThat(sum(5, new int[] {1,2,3,4,5})).isEqualTo(15);
        assertThat(binarySearch(new String[] {"a","b","c","d","e"}, "d", 0, 4 )).isEqualTo(3);
    }
}
