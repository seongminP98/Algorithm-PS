import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Add123n9095 {
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        d = new int[11];
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }

    }
    static int dp(int n){
        if(n==1 || n==0){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        if(d[n]>0)
            return d[n];
        else{
            d[n] = dp(n-3)+dp(n-2)+dp(n-1);
        }
        return d[n];
    }
}
