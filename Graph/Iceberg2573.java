import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Iceberg2573 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

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

        while (check()) {
            bfs();
            answer++;
        }
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    q.add(new Node(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0) {
                    arr[nx][ny]--;
                }
            }
        }
    }

    static boolean check() {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0)
                    visited[i][j] = true;
                else {
                    flag = true;
                    if (q.isEmpty()) {
                        visited[i][j] = true;
                        q.add(new Node(i, j));
                    }
                }
            }
        }
        if (!flag) { // 전부 다 녹을 때까지 두 덩어리 이상으로 분리 되지 않을 경우.
            System.out.println(0);
            System.exit(0);
        }
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        for (boolean[] booleans : visited) {
            for (boolean c : booleans) {
                if (!c) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Next {
        int x, y, count;

        public Next(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
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
