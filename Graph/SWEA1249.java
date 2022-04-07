import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1249 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[][] dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs(N, arr, dp);
            sb.append(dp[N - 1][N - 1]).append('\n');
        }
        System.out.print(sb);
    }

    static void bfs(int N, int[][] arr, int[][] dp) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        dp[0][0] = 0;
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && dp[c.x][c.y] + arr[nx][ny] < dp[nx][ny]) {
                    q.add(new Node(nx, ny));
                    dp[nx][ny] = dp[c.x][c.y] + arr[nx][ny];
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
