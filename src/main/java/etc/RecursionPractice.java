package etc;

import org.junit.Test;

public class RecursionPractice {

    private int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //  m >= n 인 두 정수의 최대공약수
    private double gcd(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        if (m % n == 0) {
            return n;
        }

        return gcd(n, m % n);
    }

    // 간단한 버전 p >= q
    private int simpleGcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        return simpleGcd(q, p % q);
    }

    @Test
    public void test() {
        System.out.println(fibonacci(14));
        System.out.println(gcd(12, 3));
        System.out.println(simpleGcd(12, 3));
        System.out.println(simpleGcd(12, 12));
    }
}
