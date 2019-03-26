package programmers.lv2;

public class 쇠막대기 {
    public int solution(String arrangement) {
        int answer = 0;
        String[] splited = arrangement.split("");

        int[] converted = new int[splited.length];
        for (int i = 0; i < splited.length; i++) {
            converted[i] = splited[i].equals("(") ? 1 : -1;
        }

        for (int i = 0; i < converted.length; i++) {
            if (converted[i] == 1) {
                int pair = 0;

                for (int j = i; j < converted.length; j++) {
                    pair += converted[j];

                    if(pair == 0) {
                        answer += countPieces(arrangement.substring(i, j));
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private int countPieces(String stick) {
        int count = 0;
        String[] splited = stick.split("");

        for (int i = 0; i < splited.length - 1; i++) {
            if(splited[i].equals("(") && splited[i + 1].equals(")")) {
                count++;
            }
        }

        if(count == 0) {
            return 0;
        }

        return count + 1;
    }

    public int 참고풀이(String arrangement) {
        int answer = 0;
        int sticks = 0;

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') {
                sticks++;
            } else if (arrangement.charAt(i - 1) == '('){
                answer += --sticks;
            } else {
                sticks--;
                answer++;
            }
        }

        return answer;
    }
}