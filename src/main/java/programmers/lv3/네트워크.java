package programmers.lv3;

public class 네트워크 {

    private static boolean[] visit = new boolean[200];

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                answer++;
                dfs(i, computers);
            }
        }

        return answer;
    }

    private void dfs(int index, int[][] computers) {
        visit[index] = true;

        for (int i = 0; i < computers.length; i++) {
            if(!visit[i] && computers[index][i] == 1) {
                dfs(i, computers);
            }
        }
    }

}
