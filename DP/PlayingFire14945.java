import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayingFire14945 {
    static final int DIV = 10_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1]; // 타일수, 두 사람의 거리
        dp[2][1] = 2;
        /**
         * 방법 4가지
         * 아래 아래 - 거리 이전과 동일
         * 아래 대각선 - 이전거리 +1
         * 대각선 아래 - 이전거리 -1
         * 대각선 대각선 - 거리 이전과 동일
         */
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIV;
            }
        }
        int answer = 0;
        for (int i = 1; i < N; i++) {
            answer += dp[N][i];
            answer %= DIV;
        }
        System.out.println(answer);
/*        int[][] dp = new int[N + 1][2];
        dp[2][0] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % DIV;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] * 3) % DIV;
        }
        System.out.println((dp[N][0] + dp[N][1]) * 2 % DIV);*/
    }
}
