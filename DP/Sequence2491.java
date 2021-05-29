import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence2491 {
    static int N;
    static int[] arr;
    static Integer[] dp;
    static boolean check;
    static int same;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new Integer[N+1];
        dp[0] = 1;
        if(N>1){
            if(arr[0]<arr[1]){
                check = true; //증가
            }
            if(arr[0]==arr[1]){
                same=2;
            }
            for(int i=0; i<N; i++){
                solve(i);
            }
        }

//        for(int i=0; i<N+2; i++){
//            System.out.print(dp[i]+" ");
//        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            ans = Math.max(ans,dp[i]);
        }
        //System.out.println();
        System.out.println(ans);

    }
    static void solve(int start){
        if(dp[start] == null){
            if(check){
                if(arr[start]>arr[start-1]){
                    dp[start] = dp[start-1]+1;
                    same=1;
                }
                else if(arr[start]==arr[start-1]){
                    dp[start] = dp[start-1]+1;
                    same++;
                }

                else{
                    check = false;
                    dp[start] = same+1;
                    same=1;
                }
            } else{
                if(arr[start]<arr[start-1]){
                    dp[start] = dp[start-1]+1;
                    same=1;
                }
                else if(arr[start]==arr[start-1]){
                    dp[start] = dp[start-1]+1;
                    same++;
                }

                else{
                    check = true;
                    dp[start] = same+1;
                    same=1;
                }
            }
        }
    }
}