import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker9465 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n+1];
            int[][] arr = new int[2][n+1];
            StringTokenizer st;
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<n+1; j++){
                    arr[i][j]= Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1]; //n=1일 때의 값
            dp[1][1] = arr[1][1];
            for(int i=2; i<n+1; i++){
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i]; //1행i열 스티커를 때려면 그 스티커의 값과 이 스티커를 땔수있는 경우인 2행 i-1열 i-2열 중 큰 값을 더한다.
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i];       //1행 i-2열 스티커를 때두 되는데 이건 2행 i-1열에서 이미 고려했다.
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }
    }
}
