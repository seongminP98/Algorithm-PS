import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PinaryNumber2193 {
    static long[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new long[N+1];
        System.out.println(dp(N));
    }
    static long dp(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        if(d[n]==0){
            d[n] = dp(n-2)+dp(n-1);
        }
        return d[n];
    }
}
