package programmers.lv2;

public class 네트워크 {
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                searchNetwork(i, computers);
            }
        }

        return answer;
    }

    private void searchNetwork(int index, int[][] computers) {
        visited[index] = true;

        for (int i = 0; i < computers.length; i++) {
            if(computers[index][i] == 1 && !visited[i]) {
                searchNetwork(i, computers);
            }
        }
    }
}
