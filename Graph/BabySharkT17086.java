import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabySharkT17086 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, -1, 0, 1, -1, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);

    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (arr[nx][ny] == 1) {
                        return c.dis + 1;
                    }
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, c.dis + 1));
                }
            }
        }
        return 0;
    }

    private static class Node {
        int x, y, dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
