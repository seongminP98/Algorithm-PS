import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TurnArray17406 {
    static int[][] arr;
    static int N, M, K;
    static int[][] info;
    static int answer = 5000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        info = new int[K][3]; // r,c,s
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(0, new boolean[K]);
        System.out.println(answer);
    }

    private static void permutation(int depth, boolean[] visited) {
        if (depth == K) {
            solution();
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                rotate(i, false);
                permutation(depth + 1, visited);
                rotate(i, true);
                visited[i] = false;
            }
        }
    }

    private static void rotate(int idx, boolean isReverse) {
        int sx = info[idx][0] - info[idx][2];
        int sy = info[idx][1] - info[idx][2];
        int ex = info[idx][0] + info[idx][2];
        int ey = info[idx][1] + info[idx][2];
        int rotateCount = Math.min(ex - sx, ey - sy);
        if (rotateCount % 2 != 0) rotateCount++;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        if (isReverse) {
            dx = new int[]{1, 0, -1, 0};
            dy = new int[]{0, 1, 0, -1};
        }

        for (int k = 0; k < rotateCount; k++) {
            int x = sx;
            int y = sy;
            int num = arr[x][y];
            for (int d = 0; d < 4; d++) {
                int moveCnt = d % 2 == 0 ? ey - sy : ex - sx;
                num = move(d, moveCnt, x, y, num, dx, dy);
                x += (dx[d] * moveCnt);
                y += (dy[d] * moveCnt);
            }
            sx++;
            sy++;
            ex--;
            ey--;
        }
    }

    private static int move(int dir, int cnt, int x, int y, int num, int[] dx, int[] dy) {
        for (int i = 0; i < cnt; i++) {
            x += dx[dir];
            y += dy[dir];
            int next = arr[x][y];
            arr[x][y] = num;
            num = next;
        }
        return num;
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
            }
            answer = Math.min(answer, sum);
        }
    }
}
