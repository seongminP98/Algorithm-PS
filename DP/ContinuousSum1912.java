import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum1912 {
    static Long[] arr;
    static Long[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Long[N];
        d = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        d[0] = arr[0];
        for(int i=1; i<N; i++){
            dp(i);
        }
        long max = d[0];
        for(int i=1; i<N; i++){
            max = Math.max(max,d[i]);
        }
        System.out.println(max);
    }
    static long dp(int n){
        if(d[n]==null){
            d[n] = Math.max(arr[n],dp(n-1)+arr[n]);
        }
        return d[n];
    }
}
