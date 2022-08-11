import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BallOnTheChessboard16957 {
    static int R, C;
    static int[][] arr;
    static int[][] ball;
    static Node[][] dp;
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 0, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ball = new int[R][C];
        for (int[] ints : ball) {
            Arrays.fill(ints, 1);
        }
        dp = new Node[R][C]; // 최종 목적지 위치 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ball[i][j] == 1) {
                    dfs(i, j, 0);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] ints : ball) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static Node dfs(int x, int y, int cnt) {
        int min = arr[x][y];
        int mx = 0;
        int my = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (min > arr[nx][ny]) {
                mx = nx;
                my = ny;
                min = arr[nx][ny];
            }
        }
        if (min != arr[x][y]) {
            cnt += ball[x][y];
            ball[x][y] = 0;
            if(dp[mx][my] != null) {
                ball[dp[mx][my].x][dp[mx][my].y] += cnt;
                return dp[mx][my];
            }
            return dp[x][y] = dfs(mx, my, cnt);
        } else {//최종목적지
            ball[x][y] += cnt;
            return new Node(x, y);
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
