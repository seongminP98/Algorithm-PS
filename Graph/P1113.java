import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1113 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
                maxH = Math.max(maxH, arr[i][j]);
            }
        }
        for (int h = 2; h <= maxH; h++) {
            boolean[][] visited = new boolean[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (!visited[i][j] && arr[i][j] < h) {
                        visited[i][j] = true;
                        bfs(i, j, visited, h);
                    }
                }
            }
        }
        System.out.println(answer);

    }

    private static void bfs(int x, int y, boolean[][] visited, int h) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int cnt = 1;
        boolean flag = false;
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                /* 밖으로 나가고 바로 return 하면 틀림.. 반례 (방문 처리 때문)
                    4 5
                    11111
                    32223
                    41114
                    44444 
                 */
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { 
                    flag = true;
                    continue;
                }
                if (arr[nx][ny] < h && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }
        if(!flag) {
            answer += cnt;
        }
    }

    private static class Node {
        int x, y;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
