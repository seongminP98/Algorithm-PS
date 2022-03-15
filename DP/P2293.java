import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293 {
    static int n, k;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n];
        dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {//동전
            for (int j = coin[i]; j <= k; j++) {//경우의 수 갱신
                dp[j] = dp[j] + dp[j - coin[i]]; //현재 경우의 수 + i번째 코인을 추가해서 얻을 수 있는 경우의 수
            }
        }
        System.out.println(dp[k]);
    }
}
