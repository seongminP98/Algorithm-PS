import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoTo11048 {
    static int N,M;
    static int[][] arr;
    static Integer[][] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d = new Integer[N+1][M+1];
        d[1][1] = arr[1][1];
        dp(N,M);
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=M; j++){
//                System.out.print(d[i][j]+" ");
//            }System.out.println();
//        }
        System.out.println(d[N][M]);

    }
    static int dp(int x, int y){
        if(d[x][y] == null){
            d[x][y] = arr[x][y];
            int max = 0;
            if(x-1>=1){
                max = Math.max(max,dp(x-1,y));
            }
            if(y-1>=1){
                max = Math.max(max,dp(x,y-1));
            }
            if(x-1>=1 && y-1>=1){
                max = Math.max(max,dp(x-1,y-1));
            }
            d[x][y] = max+arr[x][y];
        }
        return d[x][y];
    }

}
