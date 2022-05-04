import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bishop1799 {
    static int N;
    static boolean[][] arr;
    static boolean[][] visited;
    static int answer = 0;
    static int answer2 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    arr[i][j] = true;
                }
            }
        }
        // 동서남북으로 한칸 띄어져있으면 무조건 놓을 수 있음. 나눠서 생각.
        dfs(0, 0, true, N % 2 == 0); // N이 짝수면 row 하나가 끝날 때 3칸 1칸 씩.
        dfs(0, 1, false, N % 2 == 0); // N이 홀수면 2칸씩 확인하면 됨.
        System.out.println(answer + answer2);
    }

    private static void dfs(int cnt, int idx, boolean flag, boolean isEven) {
        for (int i = idx; i < N * N; i += 2) {
            if (isEven) {
                if (i % N == 0 && i != 0) {
                    i++;

                } else if (i % N == 1 && i != 1) {
                    i--;
                }
            }

            int x = i / N;
            int y = i % N;
            if (arr[x][y] && check(x, y) && !visited[x][y]) {
                visited[x][y] = true;
                dfs(cnt + 1, i + 2, flag, isEven);
                visited[x][y] = false;
            }
        }
        if (flag) {
            answer = Math.max(answer, cnt);
        } else {
            answer2 = Math.max(answer2, cnt);
        }
    }

    private static boolean check(int x, int y) {
        int nx = x;
        int ny = y;
        while (nx >= 0 && ny >= 0) {
            if (visited[nx][ny]) {
                return false;
            }
            nx -= 1;
            ny -= 1;
        }
        nx = x - 1;
        ny = y + 1;
        while (nx >= 0 && ny < N) {
            if (visited[nx][ny]) {
                return false;
            }
            nx -= 1;
            ny += 1;
        }
        return true;
    }
}
