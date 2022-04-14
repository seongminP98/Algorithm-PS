import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P9466 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] isTeam;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            isTeam = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = N;
            for (int i = 1; i <= N; i++) {
                if (!isTeam[i]) {
//                    visited = new boolean[N + 1]; //이렇게 하면 시간초과..
                    dfs(i);
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if (visited[idx]) { // 방문한애를 또 방문하면 사이클. 팀이 된다.
            isTeam[idx] = true;
            answer--;

        } else {
            visited[idx] = true;
        }

        if (!isTeam[arr[idx]]) { // 다음사람을 두번 방문 안했으면 재귀. 무조건 한명은 두번 방문함.
            dfs(arr[idx]);
        }
        isTeam[idx] = true; // 팀이 됐든 안됐든 끝남.
        visited[idx] = false; // 이렇게 안하고 dfs 들어오기 전에 새로 만들면 시간초과..
    }
}
