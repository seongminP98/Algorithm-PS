import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wedding5567 {
    static int[][] arr;
    static boolean[] visited;
    static int answer;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        answer = 0;
        visited = new boolean[N + 1];
        visited[1] = true;
        
        dfs(1, 0);

        for (boolean b : visited) {
            if (b) answer++;
        }

        System.out.println(answer - 1);
    }

    static void dfs(int x, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (arr[x][i] == 1) {
                visited[i] = true;
                dfs(i, depth + 1);
            }
        }
    }
}
