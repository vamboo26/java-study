package programmers.kakao;

import java.util.*;

//14:19 ~ 14:38, 성능고려X 리팩토링X 구현만 20분
//TODO
// Queue, List<String[]> 어떤 선택이 옳을까? 아니면 다른?
// Log객체는 분리하는 게 좋을까? 배열을 그냥쓰는 건 읽기에 나쁘지 않을까?
// StringBuilder, String concat, String format performance 차이 존재? -> StringBuilder 짱짱
public class OpenChatRoom {

    public String[] solution(String[] record) {
        Map<String, String> userIdAndName = new HashMap<>();
        Queue<Log> logs = new LinkedList<>();

        for (String eachRecord : record) {
            String[] messageTokens = eachRecord.split(" ");
            String messageType = messageTokens[0];
            String userId = messageTokens[1];

            if(eachRecord.startsWith("Change")) {
                String name = messageTokens[2];
                userIdAndName.put(userId, name);
            } else if(eachRecord.startsWith("Enter")) {
                String name = messageTokens[2];
                userIdAndName.put(userId, name);
                logs.add(new Log(messageType, userId));
            } else {
                logs.add(new Log(messageType, userId));
            }
        }

        String[] answer = new String[logs.size()];

        for (int i = 0; i < answer.length; i++) {
            Log log = logs.poll();
            answer[i] = log.logMessage(userIdAndName.get(Objects.requireNonNull(log).userId));
        }

        return answer;


        //TODO
        // 성능차가 많이 난다... 그냥 위처럼... 아래는 오히려 가독성도 구린듯
//        return Arrays.stream(logs.stream()
//                .map(i -> i.logMessage(userIdAndName.get(i.userId)))
//                .toArray())
//                .map(Object::toString)
//                .toArray(String[]::new);
    }

    class Log {

        String type;
        String userId;

        Log(String type, String userId) {
            this.type = type;
            this.userId = userId;
        }

        String logMessage(String name) {
            StringBuilder sb = new StringBuilder(name);

            return type.equals("Enter")
                    ? sb.append("님이 들어왔습니다.").toString()
                    : sb.append("님이 나갔습니다.").toString();
        }

    }

}




    /*
        "[닉네임]님이 들어왔습니다."
        "[닉네임]님이 나갔습니다."
    Muzi가 나간후 다시 들어올 때, Prodo 라는 닉네임으로 들어올 경우
    기존에 채팅방에 남아있던 Muzi도 Prodo로 다음과 같이 변경된다.

    채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후,
    최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.


String format 사용

테스트 1 〉	통과 (6.28ms, 47.9MB)
테스트 2 〉	통과 (6.05ms, 48.3MB)
테스트 3 〉	통과 (7.63ms, 48.3MB)
테스트 4 〉	통과 (8.75ms, 47.8MB)
테스트 5 〉	통과 (34.11ms, 51MB)
테스트 6 〉	통과 (40.35ms, 50.8MB)
테스트 7 〉	통과 (33.38ms, 51MB)
테스트 8 〉	통과 (41.59ms, 50.7MB)
테스트 9 〉	통과 (40.41ms, 51.3MB)
테스트 10 〉	통과 (40.33ms, 51.3MB)
테스트 11 〉	통과 (22.58ms, 48.1MB)
테스트 12 〉	통과 (26.18ms, 48.3MB)
테스트 13 〉	통과 (35.56ms, 50.9MB)
테스트 14 〉	통과 (36.55ms, 50.9MB)
테스트 15 〉	통과 (5.88ms, 48.6MB)
테스트 16 〉	통과 (6.57ms, 47.8MB)
테스트 17 〉	통과 (10.63ms, 48.1MB)
테스트 18 〉	통과 (10.21ms, 48.1MB)
테스트 19 〉	통과 (44.11ms, 50.3MB)
테스트 20 〉	통과 (32.91ms, 50.5MB)
테스트 21 〉	통과 (32.03ms, 50.1MB)
테스트 22 〉	통과 (30.31ms, 49.9MB)
테스트 23 〉	통과 (38.94ms, 51.5MB)
테스트 24 〉	통과 (41.72ms, 50.6MB)
테스트 25 〉	통과 (441.74ms, 162MB)
테스트 26 〉	통과 (492.00ms, 168MB)
테스트 27 〉	통과 (510.36ms, 172MB)
테스트 28 〉	통과 (497.31ms, 178MB)
테스트 29 〉	통과 (507.90ms, 180MB)
테스트 30 〉	통과 (489.90ms, 159MB)
테스트 31 〉	통과 (588.58ms, 172MB)
테스트 32 〉	통과 (438.87ms, 168MB)

StringBulder 사용

테스트 1 〉	통과 (5.02ms, 48MB)
테스트 2 〉	통과 (5.40ms, 48.2MB)
테스트 3 〉	통과 (5.19ms, 47.8MB)
테스트 4 〉	통과 (5.88ms, 47.9MB)
테스트 5 〉	통과 (13.47ms, 50.8MB)
테스트 6 〉	통과 (14.25ms, 50.4MB)
테스트 7 〉	통과 (13.88ms, 50.2MB)
테스트 8 〉	통과 (14.06ms, 50.2MB)
테스트 9 〉	통과 (14.53ms, 51MB)
테스트 10 〉	통과 (12.84ms, 50.3MB)
테스트 11 〉	통과 (11.01ms, 50.5MB)
테스트 12 〉	통과 (11.86ms, 48.1MB)
테스트 13 〉	통과 (24.52ms, 51MB)
테스트 14 〉	통과 (14.17ms, 50.9MB)
테스트 15 〉	통과 (5.32ms, 47.7MB)
테스트 16 〉	통과 (5.37ms, 48MB)
테스트 17 〉	통과 (6.25ms, 47.9MB)
테스트 18 〉	통과 (5.68ms, 48.5MB)
테스트 19 〉	통과 (18.48ms, 51.8MB)
테스트 20 〉	통과 (12.98ms, 50.5MB)
테스트 21 〉	통과 (14.74ms, 50.4MB)
테스트 22 〉	통과 (18.49ms, 50.9MB)
테스트 23 〉	통과 (14.57ms, 50.2MB)
테스트 24 〉	통과 (15.00ms, 49.8MB)
테스트 25 〉	통과 (247.58ms, 153MB)
테스트 26 〉	통과 (299.99ms, 155MB)
테스트 27 〉	통과 (264.18ms, 160MB)
테스트 28 〉	통과 (312.50ms, 172MB)
테스트 29 〉	통과 (339.60ms, 171MB)
테스트 30 〉	통과 (251.88ms, 151MB)
테스트 31 〉	통과 (282.08ms, 161MB)
테스트 32 〉	통과 (260.75ms, 153MB)

String + 연산자 이용
1.5 이후에는 컴파일러가 알아서 StringBuilder 변환처리해준다고 하지만 베스트케이스로 처리되지 않는듯?
http://egloos.zum.com/deblan2/v/419830 참조

테스트 1 〉	통과 (21.17ms, 48.3MB)
테스트 2 〉	통과 (20.86ms, 48.3MB)
테스트 3 〉	통과 (21.10ms, 49.6MB)
테스트 4 〉	통과 (21.76ms, 49.2MB)
테스트 5 〉	통과 (32.06ms, 50.9MB)
테스트 6 〉	통과 (32.37ms, 52MB)
테스트 7 〉	통과 (28.98ms, 51.3MB)
테스트 8 〉	통과 (38.34ms, 51.9MB)
테스트 9 〉	통과 (33.49ms, 51.2MB)
테스트 10 〉	통과 (30.43ms, 50.5MB)
테스트 11 〉	통과 (41.60ms, 52.3MB)
테스트 12 〉	통과 (28.97ms, 48.5MB)
테스트 13 〉	통과 (40.38ms, 52.2MB)
테스트 14 〉	통과 (34.63ms, 50.6MB)
테스트 15 〉	통과 (21.61ms, 48.6MB)
테스트 16 〉	통과 (21.71ms, 48.2MB)
테스트 17 〉	통과 (23.48ms, 48.7MB)
테스트 18 〉	통과 (21.38ms, 49.6MB)
테스트 19 〉	통과 (59.20ms, 52.4MB)
테스트 20 〉	통과 (30.01ms, 51.7MB)
테스트 21 〉	통과 (30.18ms, 50.4MB)
테스트 22 〉	통과 (35.58ms, 52.6MB)
테스트 23 〉	통과 (39.85ms, 51.9MB)
테스트 24 〉	통과 (39.88ms, 50.8MB)
테스트 25 〉	통과 (255.76ms, 163MB)
테스트 26 〉	통과 (301.35ms, 158MB)
테스트 27 〉	통과 (306.63ms, 153MB)
테스트 28 〉	통과 (270.35ms, 153MB)
테스트 29 〉	통과 (250.28ms, 149MB)
테스트 30 〉	통과 (297.21ms, 156MB)
테스트 31 〉	통과 (227.14ms, 143MB)
테스트 32 〉	통과 (230.21ms, 137MB)
     */

