import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumOfAsc11057 {
    static long[][] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new long[n+1][10];
        for(int i=0; i<10; i++){
            d[1][i] = 1;
        }
        long result=0;
        for(int i=0; i<10; i++){
            result+=dp(n,i);
        }
        System.out.println(result%10007);

    }
    static long dp(int n,int i){
        if(n==1)
            return 1;
        long sum=0;
        if(d[n][i]==0){
            for(int j=0; j<=i; j++){
                sum+=dp(n-1,j);
            }
            d[n][i] = sum;
        }
        return d[n][i]%10007;
    }
}
