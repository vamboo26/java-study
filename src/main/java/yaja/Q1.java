package yaja;

import org.junit.Test;

import static yaja.Q1.TimeStringConverter.*;

public class Q1 {

    private static final int SEC_OF_HOUR = 3600;
    private static final int SEC_OF_MIN = 60;
    private static final String HOUR_FORMAT = "h";
    private static final String MIN_FORMAT = "m";
    private static final String SEC_FORMAT = "s";

    public String solution(int T) {
        return convertToTimeFormatString(T);
    }

    private String convertToTimeFormatString(int sec) {
        StringBuilder result = new StringBuilder();

        for (TimeStringConverter unit : TimeStringConverter.values()) {
            result.append(unit.convert(sec));
        }

        System.out.println(String.format("%d%s%d%s%d%s",HOUR.convert(sec),HOUR_FORMAT,MIN.convert(sec),MIN_FORMAT, SEC.convert(sec),SEC_FORMAT));


        return result.toString();
    }

    public enum TimeStringConverter {
        HOUR {
            @Override
            public int convert(int sec) {
                return sec / SEC_OF_HOUR;
            }
        },
        MIN {
            @Override
            public int convert(int sec) {
                return sec % SEC_OF_HOUR / SEC_OF_MIN;
            }
        },
        SEC {
            @Override
            public int convert(int sec) {
                return sec % SEC_OF_HOUR % SEC_OF_MIN;
            }
        };

        public abstract int convert(int sec);
    }

    @Test
    public void test() {

        System.out.println(solution(86400));
//        System.out.println(solution(7500));
//        System.out.println(solution(0));
//        System.out.println(solution(11111));
//        System.out.println(solution(83643));
    }

}
