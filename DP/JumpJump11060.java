import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpJump11060 {
    static int N;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new Integer[N+1];
        dp[1] = 0;
        for(int i=1; i<=N; i++){
            if(dp[i] != null){
                int jump = arr[i];
                for(int j=1; j<=jump; j++){
                    if(i+j<=N){
                        if(dp[i+j]==null){
                            dp[i+j]=dp[i]+1;
                        }else
                            dp[i+j] = Math.min(dp[i+j],dp[i]+1);
                    }
                }
            }
        }
        System.out.println(dp[N]==null ? -1 : dp[N]);
    }
}
