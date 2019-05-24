package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

//TODO googled https://bcp0109.tistory.com/9
public class Q7576 {
    private static int height;
    private static int width;
    private static int[][] box;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        width = Integer.parseInt(stk.nextToken());
        height = Integer.parseInt(stk.nextToken());

        box = new int[height][width];

        for (int i = 0; i < height; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                box[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<Node>();
        int day = 0;

        // 토마토가 있는 좌표 찾아서 Queue에 넣기
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 1)
                    q.offer(new Node(i, j, 0));
            }
        }

        // bfs 시작
        while (!q.isEmpty()) {
            Node node = q.poll();
            day = node.day;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (0 <= nx && nx < height && 0 <= ny && ny < width) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Node(nx, ny, day + 1));
                    }
                }
            }
        }

        // 토마토가 다 익었는지 확인
        if (checkTomato())
            System.out.println(day);
        else
            System.out.println(-1);
    }

    // box 배열에 0이 남아있다면 false, 아니면 true
    static boolean checkTomato() {
        return Stream.of(box)
                .flatMapToInt(Arrays::stream)
                .noneMatch(i -> i == 0);
    }

    static class Node {
        int x;
        int y;
        int day;

        Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}
