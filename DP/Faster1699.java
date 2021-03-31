import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Faster1699 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i] = i;
            for(int j = 1; j*j <= i; j++)
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1); //n보다 작은 수 중 제곱수+1 한 것중 젤 작은것 선택
        }

        System.out.println(dp[n]);
    }
}
