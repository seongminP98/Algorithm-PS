import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MonkeyWantHorse1600 {
    static int K, W, H;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dxH = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dyH = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W][H];
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < H; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(-1);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        boolean[][][] visited = new boolean[W][H][K + 1];
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.x == W - 1 && c.y == H - 1) {
                System.out.println(c.cnt);
                System.exit(0);
            }
            if (c.horse < K) { //말 움직임 가능
                for (int i = 0; i < 8; i++) {
                    int nx = c.x + dxH[i];
                    int ny = c.y + dyH[i];
                    if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[nx][ny][c.horse + 1] && arr[nx][ny] == 0) {
                        q.add(new Node(nx, ny, c.cnt + 1, c.horse + 1));
                        visited[nx][ny][c.horse + 1] = true;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[nx][ny][c.horse] && arr[nx][ny] == 0) {
                    q.add(new Node(nx, ny, c.cnt + 1, c.horse));
                    visited[nx][ny][c.horse] = true;
                }
            }

        }
    }

    static class Node {
        int x, y, cnt, horse;

        public Node(int x, int y, int cnt, int horse) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.horse = horse;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", horse=" + horse +
                    '}';
        }
    }
}
