import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance1149 {
    static int N;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        int ans = Math.min(solve(N-1,0),Math.min(solve(N-1,1),solve(N-1,2)));
        System.out.print(ans);
    }
    static int solve(int n, int color){
        if(dp[n][color]==0){
            if(color==0){
                dp[n][0] = arr[n][0] + Math.min(solve(n-1,1),solve(n-1,2));
            } else if(color==1){
                dp[n][1] = arr[n][1] + Math.min(solve(n-1,0),solve(n-1,2));
            } else{
                dp[n][2] = arr[n][2] + Math.min(solve(n-1,0),solve(n-1,1));
            }
        }

        return dp[n][color];
    }
}
