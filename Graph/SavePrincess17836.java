import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SavePrincess17836 {
    static int N, M, T;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println("Fail");
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, false, 0));
        arr[0][0] = -1;
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.time + 1 > T) {
                System.out.println("Fail");
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(c.time + 1);
                    System.exit(0);
                }
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (c.gram && arr[nx][ny] != -2) {
                        arr[nx][ny] = -2;
                        q.add(new Node(nx, ny, true, c.time + 1));
                    } else if (!c.gram) {
                        if (arr[nx][ny] == 0) {
                            arr[nx][ny] = -1;
                            q.add(new Node(nx, ny, false, c.time + 1));
                        } else if (arr[nx][ny] == 2) {
                            arr[nx][ny] = -2;
                            q.add(new Node(nx, ny, true, c.time + 1));
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, time;
        boolean gram;

        public Node(int x, int y, boolean gram, int time) {
            this.x = x;
            this.y = y;
            this.gram = gram;
            this.time = time;
        }
    }
}
