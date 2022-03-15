import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OneTwoThreeAddT15988 {
    static int MOD = 1000000009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[1000001];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for (int t = 0; t < T; t++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        
        System.out.print(sb);
    }
}
