import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backpack12865 {
    static int N,K;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //무게
        arr = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new Integer[N][K+1];
        System.out.println(solution(N-1,K));
    }
    static int solution(int i, int k){
        if(i<0)
            return 0;

        if(dp[i][k] == null){
            if(arr[i][0]>k){
                dp[i][k] = solution(i-1,k);
            } else{
                dp[i][k] = Math.max(solution(i-1,k),arr[i][1]+solution(i-1,k-arr[i][0]));
            }
        }
        return dp[i][k];
    }
}
