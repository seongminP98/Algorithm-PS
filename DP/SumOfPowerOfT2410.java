import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfPowerOfT2410 {
    static int[] dp;
    static final int MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }
        if (N == 2) {
            System.out.println(2);
            System.exit(0);
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] % MOD + dp[i / 2] % MOD) % MOD;
        }
        System.out.println(dp[N]);
    }
}
