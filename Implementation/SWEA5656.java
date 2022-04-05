import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int N, W, H;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = W * H;
            arr = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(0);
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static void solve(int depth) {
        if (depth == N) {
            countBlock();
            return;
        }
        for (int i = 0; i < W; i++) {
            int[][] before = new int[H][W];
            for (int j = 0; j < H; j++) {
                if (W >= 0) System.arraycopy(arr[j], 0, before[j], 0, W);
            }
            findCrush(i);
            fallDown();
            solve(depth + 1);
            for (int j = 0; j < H; j++) {
                if (W >= 0) System.arraycopy(before[j], 0, arr[j], 0, W);
            }
        }

    }

    static void findCrush(int y) {
        int x = 0;
        while (x < H && arr[x][y] == 0) {
            x++;
        }
        if (x == H) return;
        crush(x, y, arr[x][y] - 1);

    }

    static void crush(int x, int y, int cnt) {
        arr[x][y] = 0;
        while (cnt > 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] * cnt;
                int ny = y + dy[i] * cnt;
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && arr[nx][ny] != 0) {
                    if (arr[nx][ny] > 1) {
                        crush(nx, ny, arr[nx][ny] - 1);
                    }
                    arr[nx][ny] = 0;
                }
            }
            cnt--;
        }
    }

    static void fallDown() {
        for (int i = H - 2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 0)
                    continue;
                int cnt = 0;
                for (int k = i + 1; k < H; k++) {
                    if (arr[k][j] == 0) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt > 0) {
                    arr[i + cnt][j] = arr[i][j];
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void countBlock() {
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        if (sum < answer) answer = sum;
    }
}
