import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TurnArray16927 {
    static int N, M, R;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Math.min(N, M) / 2;
        int rotate = (N + M) * 2 - 4;
        for (int i = 0; i < min; i++) {
            int r = R % rotate;
            for (int j = 0; j < r; j++) {
                int x = i;
                int y = i;
                int value = arr[x][y];
                int d = 0;
                while (d < 4) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= i && nx < N - i && ny >= i && ny < M - i) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        d++;
                    }
                }
                arr[i + 1][i] = value;
            }
            rotate -= 8;
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
