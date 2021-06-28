import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DeploymentSoldieres18353 {
    static int N;
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        d = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = 1;
        for(int i=0; i<N; i++){
            dp(i);
        }
        int ans = Integer.MIN_VALUE;
        for(int v : d){
            ans = Math.max(ans,v);
        }
        System.out.print(N-ans);

    }
    static int dp(int n){
        if(d[n]==0){
            d[n]=1;
            for(int i=n-1; i>=0; i--){
                if(arr[n]<arr[i]){
                    d[n] = Math.max(d[n],dp(i)+1);
                }
            }
        }
        return d[n];
    }

}
