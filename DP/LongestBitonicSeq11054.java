import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestBitonicSeq11054 {
    static int[] arr;
    static int[] d;
    static int[] d2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];
        d2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d[0]=1;
        d2[0]=1;
        for(int i=0; i<N; i++){
            dp(i);
            dp2(i);
        }
        int max = d[0];
        for(int i=1; i<N; i++){
            if(max<d[i])
                max=d[i];
        }
        System.out.println(max);
    }
    static int dp(int n){ //감소하는 가장 긴 부분 수열
        if(d[n]==0){
            d[n]=1;

            for(int i=n-1;i>=0; i--){        //이전 값이 커진것과 비교.
                if(arr[i]>arr[n]){
                    d[n] = Math.max(d[n],dp(i)+1);
                }
            }
            for(int i=n-1; i>=0; i--){
                if(arr[i]<arr[n]){
                    d[n] = Math.max(d[n],dp2(i)+1);
                }
            }
        }
        return d[n];
    }
    static int dp2(int n){ //증가하는 가장 긴 부분 수열
        if(d2[n]==0){
            d2[n]=1;
            for(int i=n-1; i>=0; i--){
                if(arr[i]<arr[n]){
                    d2[n] = Math.max(d2[n],dp2(i)+1);
                }
            }
        }
        return d2[n];
    }
}
