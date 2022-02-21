import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovePiPe17070 {
    static int N;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int dir) { //dir 0: 우 / 1: 하 / 2: 대각
        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }
        if (dir == 0) { //우, 대각 가능
            if (isIn(x, y + 1) && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }

        } else if (dir == 1) { //하, 대각 가능
            if (isIn(x + 1, y) && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        } else if (dir == 2) {
            if (isIn(x, y + 1) && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
            if (isIn(x + 1, y) && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        }
        if (isIn(x + 1, y + 1) && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }

    static boolean isIn(int x, int y) {
        return x < N && y < N;
    }
}
