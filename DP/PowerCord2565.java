import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PowerCord2565 {
    static int n;
    static int[][] arr;
    static Integer[] dp;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new Integer[n];
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        }); //A기준으로 오름차순 정렬
        for(int i=0; i<n; i++){
            max = Math.max(solution(i),max);
        }

        System.out.print(n-max);

    }
    static int solution(int N){
        if(dp[N] == null){
            dp[N] = 1;
            for(int i=N+1; i<n; i++){
                if(arr[N][1]<arr[i][1]){
                    dp[N] = Math.max(dp[N],solution(i)+1);
                }
            }
        }
        return dp[N];
    }
}
