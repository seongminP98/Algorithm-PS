import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leave14501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] T = new int[n+2];
        int[] P = new int[n+2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+2];
        for(int i=n; i>0; i--){
            if(i+T[i]>n+1){
                dp[i] = dp[i+1];
            } else{
                dp[i] = Math.max(P[i]+dp[i+T[i]],dp[i+1]);
            }
        }
        System.out.println(dp[1]);
    }
}

