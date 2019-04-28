package programmers.lv3;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class N으로표현 {

    public int solution(int N, int number) {
        int[][] possible = new int[8][999999999];
        possible[0] = new int[1];
        possible[0][0] = N;

        for (int i = 1; i < 8; i++) {
            possible[i] = new int[4 * possible[i - 1].length + 1];
        }


        for (int i = 1; i < 8; i++) {
            int index = 0;

            for (int j = 0; j < i / 2; j++) {

                for (int k = 0; k < possible[i - 1].length; k++) {
                    possible[i][index++] = possible[i - 1][k] * 5;
                    possible[i][index++] = possible[i - 1][k] / 5;
                    possible[i][index++] = possible[i - 1][k] + 5;
                    possible[i][index++] = possible[i - 1][k] - 5;
                }

                possible[i][index] = getDigitNumber(N, i + 1);

                for (int each : possible[i]) {
                    if(each == number) {
                        return i + 1;
                    }
                }
            }

//            for (int j = 0; j < possible[i - 1].length; j++) {
//                possible[i][index++] = possible[i - 1][j] * 5;
//                possible[i][index++] = possible[i - 1][j] / 5;
//                possible[i][index++] = possible[i - 1][j] + 5;
//                possible[i][index++] = possible[i - 1][j] - 5;
//            }
//
//            possible[i][index] = getDigitNumber(N, i + 1);
//
//            for (int each : possible[i]) {
//                if(each == number) {
//                    return i + 1;
//                }
//            }
        }

        return -1;
    }

    private int getDigitNumber(int N, int digit) {
        int sum = 0;
        for (int j = 0; j < digit; j++) {
            sum += N * Math.pow(10, j);
        }

        return sum;
    }

    @Test
    public void test() {
        int N = 5;
        int number = 12;
        assertThat(solution2(N, number)).isEqualTo(4);
    }

    public int solution2(int N, int number) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        HashSet<Integer> first = new HashSet<>();
        first.add(N);
        map.put(1, first);

        for (int i = 2; i < 9; i++) {
            //링크드해쉬셋 아니고 그냥 해쉬셋이면 틀린다...
            HashSet<Integer> temp = new LinkedHashSet<>();

            int NNN = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;

            if(NNN == number) {
                return i;
            }

            temp.add(NNN);

            for (int j = 1; j <= i / 2; j++) {
                Iterator<Integer> one = map.get(j).iterator();
                Iterator<Integer> another = map.get(i - j).iterator();

                while (one.hasNext()) {
                    int val1 = one.next();

                    while (another.hasNext()) {
                        int val2 = another.next();

                        for (Operator o : Operator.values()) {
                            int calculate = o.calculate(val1, val2);

                            if (calculate == number){
                                return i;
                            }

                            temp.add(calculate);
                        }
                    }
                }
            }

            map.put(i, temp);
        }

        return -1;
    }

    enum Operator {
        PLUS {
            @Override
            public int calculate(int i, int j) {
                return i + j;
            }
        }, MINUS {
            @Override
            public int calculate(int i, int j) {
                return i - j;
            }
        }, BACKMINUS {
            @Override
            public int calculate(int i, int j) {
                return j - i;
            }
        }, MUL {
            @Override
            public int calculate(int i, int j) {
                return i * j;
            }
        }, DIV {
            @Override
            public int calculate(int i, int j) {
                if (j == 0){
                    return 0;
                }
                return i / j;
            }
        }, BACKDIV {
            @Override
            public int calculate(int i, int j) {
                if (i == 0){
                    return 0;
                }
                return j / i;
            }
        };

        public abstract int calculate(int i, int j);
    }

}
