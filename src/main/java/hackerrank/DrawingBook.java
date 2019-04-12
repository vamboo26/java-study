package hackerrank;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DrawingBook {
    static int pageCount(int n, int p) {
        int forward = p / 2;
        int rear = (n % 2 == 0) ? (n - p + 1) / 2 : (n - p) / 2;

        return Math.min(forward, rear);
    }

    //TODO : Googled solution
    static int pageCount2(int n, int p) {
        return Math.min(p / 2, n / 2 - p / 2);
    }

    @Test
    public void test() {
        assertThat(pageCount(73201, 57075)).isEqualTo(8063);
    }
}