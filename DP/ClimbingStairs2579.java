import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClimbingStairs2579 {
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        d = new int[n+1];
        d[1]=arr[1];
        if(n>1){
            d[2]=arr[1]+arr[2];
        }
        System.out.println(dp(n));

    }
    static int dp(int n){
        if(n>2){
            if(d[n]==0){
                d[n] = Math.max(arr[n-1]+dp(n-3),dp(n-2))+arr[n];
            }
        }
        return d[n];
    }
}
