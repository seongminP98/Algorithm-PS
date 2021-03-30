import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestDecSeq11722 {
    static int[] d;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = 1;
        for(int i=0; i<N; i++){
            dp(i);
        }
        int max = d[0];
        for(int i=1; i<N; i++){
            if(max<d[i])
                max=d[i];
        }
        System.out.println(max);
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
