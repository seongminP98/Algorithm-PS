import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyCards11052 {
    static int[] d;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        d = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(N));
    }
    static int dp(int n){
        if(n==0)
            return d[0];

        if(d[n]==0){
            d[n] = arr[n];
            for(int i=1; i<=n/2; i++){
                d[n] = Math.max(d[n],dp(i)+dp(n-i));
            }
        }
        return d[n];
    }
}
