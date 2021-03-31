import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfSquare1699 {
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new int[N+1];
        d[0]=1;
        d[1]=1;
        for(int i=2; i<N+1; i++){
            dp(i);
        }

        System.out.println(d[N]);
    }
    static int dp(int n){
        if(d[n]==0){
            if(Math.sqrt(n)%1==0){
                d[n]=1;
            } else{
                d[n] = dp(n-1)+1;

                for(int i=1; i<=n/2; i++){
                    d[n] = Math.min(d[n],d[i]+d[n-i]);
                }
            }
        }
        return d[n];
    }
}
