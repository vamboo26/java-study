package yanolja;

import org.junit.Test;

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

        return result.toString();
    }

    public enum TimeStringConverter {
        HOUR {
            @Override
            public String convert(int sec) {
                return sec / SEC_OF_HOUR + HOUR_FORMAT;
            }
        },
        MIN {
            @Override
            public String convert(int sec) {
                return sec % SEC_OF_HOUR / SEC_OF_MIN + MIN_FORMAT;
            }
        },
        SEC {
            @Override
            public String convert(int sec) {
                return sec % SEC_OF_HOUR % SEC_OF_MIN + SEC_FORMAT;
            }
        };

        public abstract String convert(int sec);
    }

    @Test
    public void test() {
        System.out.println(solution(86400));
        System.out.println(solution(7500));
        System.out.println(solution(0));
        System.out.println(solution(11111));
        System.out.println(solution(83643));
    }

}
