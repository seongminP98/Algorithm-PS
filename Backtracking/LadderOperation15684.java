import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderOperation15684 {
    static int N, M, H;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1; //오른쪽으로감
            arr[a][b + 1] = 2; //왼쪽으로감
        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
        }
        System.out.println(-1);
    }

    static void dfs(int x, int count, int answer) {
        if (count == answer) {
            if (check()) {
                System.out.println(answer);
                System.exit(0);
            }
            return;
        }
        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = 1;
                    arr[i][j + 1] = 2;
                    dfs(i, count + 1, answer);
                    arr[i][j] = arr[i][j + 1] = 0;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;
            for (int j = 0; j < H; j++) {
                if (arr[x][y] == 1) {
                    y++;
                } else if (arr[x][y] == 2) {
                    y--;
                }
                x++;
            }
            if (y != i)
                return false;
        }
        return true;
    }
}
