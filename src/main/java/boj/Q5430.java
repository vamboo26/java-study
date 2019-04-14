package boj;

import java.io.*;
import java.util.*;

//AC문제
public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            bw.write(new AC(br.readLine(), br.readLine(), br.readLine()).getResult());
        }

        br.close();
        bw.close();
    }

    private static class AC {
        private String command;
        private List<String> array;

        private AC(String command, String length, String array) {
            this.command = command;
            this.array = strToList(array);
        }

        private LinkedList<String> strToList(String array) {
            array = array.replaceAll("[\\[\\]]", "");

            if(array.equals("")) {
                return new LinkedList<>();
            }

            return new LinkedList<>(Arrays.asList(array.split(",")));
        }

        private String getResult() {
            boolean reverse = false;

            for (String letter : command.split("")){
                if(letter.equals("R")) {
                    reverse = !reverse;
                }

                if(letter.equals("D")) {
                    if(array.isEmpty()) {
                        return "error \n";
                    }

                    if(reverse) {
                        array.remove(array.size() - 1);
                    } else {
                        array.remove(0);
                    }
                }
            }

            if(reverse) {
                Collections.reverse(array);
            }

            StringBuilder sb = new StringBuilder(array.toString());
            return sb.append("\n").toString().replaceAll(" ", "");
        }
    }
}


// List만 Deque로 바꿨는데 성능차이 미미
//public class Q5430 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < T; i++) {
//            bw.write(new AC(br.readLine(), br.readLine(), br.readLine()).getResult());
//        }
//
//        br.close();
//        bw.close();
//    }
//
//    private static class AC {
//        private String command;
//        private ArrayDeque<String> array;
//
//        private AC(String command, String length, String array) {
//            this.command = command;
//            this.array = strToList(array);
//        }
//
//        private ArrayDeque<String> strToList(String array) {
//            array = array.replaceAll("[\\[\\]]", "");
//
//            if(array.equals("")) {
//                return new ArrayDeque<>();
//            }
//
//            return new ArrayDeque<>(Arrays.asList(array.split(",")));
//        }
//
//        private String getResult() {
//            boolean reverse = false;
//
//            for (String letter : command.split("")){
//                if(letter.equals("R")) {
//                    reverse = !reverse;
//                }
//
//                if(letter.equals("D")) {
//                    if(array.isEmpty()) {
//                        return "error \n";
//                    }
//
//                    if(reverse) {
//                        array.removeLast();
//                    } else {
//                        array.removeFirst();
//                    }
//                }
//            }
//
//            if(reverse && !array.isEmpty()) {
//                Iterator<String> it = array.descendingIterator();
//                array = new ArrayDeque<>();
//                while (it.hasNext()) {
//                    array.add(it.next());
//                }
//            }
//
//            StringBuilder sb = new StringBuilder(array.toString());
//            return sb.append("\n").toString().replaceAll(" ", "");
//        }
//    }
//}