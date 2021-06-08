import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinT2294 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new  int[k+1]; //dp[n]은 k의 값이 n일 때 결과값.
        Arrays.fill(dp,100001); //최대값
        dp[0]=0; //k가 0이면 동전개수 0

        for(int i=0; i<n; i++){ //동전 종류만큼
            for(int j=arr[i]; j<=k; j++){
                dp[j] = Math.min(dp[j],dp[j-arr[i]]+1); //dp[j-arr[i]]+1 이거는 이번 동전의 종류를 하나 추가했을 때 최소값 찾는거
            }
        }
        if(dp[k]==100001)
            System.out.print(-1);
        else
            System.out.print(dp[k]);
    }
}
