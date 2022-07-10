import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotControl2169 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][M];
        dp[0][0] = arr[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        // 위    : i-1,j
        // 왼쪽   : i, j-1
        // 오른쪽  : i, j+1

        for (int i = 1; i < N; i++) {
            int[][] temp = new int[2][M];

            temp[0][0] = dp[i - 1][0] + arr[i][0]; // 맨 왼쪽 가치 (위에서 내려왔을때)
            for (int j = 1; j < M; j++) { // 왼쪽 > 오른쪽. 왼쪽 or 위 중 큰것 + 내 가치
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + arr[i][j];
            }

            temp[1][M - 1] = dp[i - 1][M - 1] + arr[i][M - 1]; // 맨 오른쪽 가치 (위에서 내려왔을때)
            for (int j = M - 2; j >= 0; j--) { // 오른쪽 > 왼쪽.
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + arr[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }
}
