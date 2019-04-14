package boj;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//AC문제
public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            AC ac = new AC(br.readLine(), br.readLine(), br.readLine());
            bw.write(ac.getResult() + "\n");
        }

        br.close();
        bw.close();
    }

    static class AC {
        private String command;
        private List<Integer> arr;

        AC(String command, String length, String arr) {
            this.command = command;
            this.arr = parseToArr(arr);
        }

        private LinkedList<Integer> parseToArr(String arr) {
            arr = arr.replaceAll("\\[", "").replaceAll("]","");

            if(arr.equals("")) {
                return new LinkedList<>();
            }

            return Arrays.stream(arr.split(","))
                    .filter(i -> !i.equals(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        private String getResult() {
            boolean reverse = false;

            for (String letter : command.split("")){
                if(letter.equals("R")) {
                    reverse = !reverse;
                }

                if(letter.equals("D")) {
                    if(arr.isEmpty()) {
                        return "error";
                    }

                    if(reverse) {
                        arr.remove(arr.size() - 1);
                    } else {
                        arr.remove(0);
                    }
                }
            }

            if(reverse) {
                Collections.reverse(arr);
            }

            StringBuilder sb = new StringBuilder();
            StringJoiner sj = new StringJoiner(",");

            for (Integer integer : arr) {
                sj.add(String.valueOf(integer));
            }

            return sb.append("[").append(sj).append("]").toString();
        }
    }
}