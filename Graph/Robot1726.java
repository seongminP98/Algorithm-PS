import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Robot1726 {
    static int M, N;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // row
        N = Integer.parseInt(st.nextToken()); // column
        arr = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        st = new StringTokenizer(br.readLine());
        Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        bfs(start, end);

    }

    private static void bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        boolean[][][] visited = new boolean[M + 1][N + 1][5];
        visited[start.x][start.y][start.dir] = true;
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.x == end.x && c.y == end.y && c.dir == end.dir) {
                System.out.println(c.cnt);
                System.exit(0);
            }

            for (int i = 1; i <= 3; i++) { // 직진
                int nx = c.x + dx[c.dir - 1] * i;
                int ny = c.y + dy[c.dir - 1] * i;
                if (nx >= 1 && nx <= M && ny >= 1 && ny <= N) {
                    if (arr[nx][ny] == 0) {
                        if (!visited[nx][ny][c.dir]) {
                            visited[nx][ny][c.dir] = true;
                            q.add(new Node(nx, ny, c.dir, c.cnt + 1));
                        }
                    } else {
                        break;
                    }
                }
            }

            for (int i = 1; i <= 4; i++) { // 방향 전환
                if (!visited[c.x][c.y][i] && c.dir != i) {
                    int check = 1;
                    if (c.dir == 1 && i == 2) {
                        check++;
                    } else if (c.dir == 2 && i == 1) {
                        check++;
                    } else if (c.dir == 3 && i == 4) {
                        check++;
                    } else if (c.dir == 4 && i == 3) {
                        check++;
                    }
                    visited[c.x][c.y][i] = true;
                    q.add(new Node(c.x, c.y, i, c.cnt + check));
                }
            }

        }
    }

    private static class Node {
        int x, y, dir, cnt;

        public Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
