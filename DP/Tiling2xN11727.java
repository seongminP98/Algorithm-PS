import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tiling2xN11727 {
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        d[0] = 1;
        d[1] = 1;
        System.out.println(dp(n));

    }
    static int dp(int n){
        if(d[n]>0)
            return d[n];
        else{
            d[n] = dp(n-1)+dp(n-2)+dp(n-2);
            d[n]%=10007;
        }
        return d[n];
    }
}
