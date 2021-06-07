import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OTTAddF15990 {
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp = new int[100001][4];
        dp[1][1]=1;
        dp[1][2]=0;
        dp[1][3]=0;

        dp[2][1]=0;
        dp[2][2]=1;
        dp[2][3]=0;

        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;

        for(int i=4; i<100001; i++){
            dp[i][1] = (dp[i-1][2]+dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][1]+dp[i-2][3])%1000000009;
            dp[i][3] = (dp[i-3][1]+dp[i-3][2])%1000000009;
        }
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            sum+=dp[n][1];
            sum%=1000000009;
            sum+=dp[n][2];
            sum%=1000000009;
            sum+=dp[n][3];
            sum%=1000000009;

            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
