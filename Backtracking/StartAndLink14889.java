import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StartAndLink14889 {
    static int N;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[N];

        solve(0,0);
        System.out.println(ans);
    }
    static void solve(int depth, int start){
        if(depth == N/2){
            ArrayList<Integer> teamL = new ArrayList<>();
            ArrayList<Integer> teamS = new ArrayList<>();
            for(int i=0; i<N; i++){
                if(check[i]){
                    teamL.add(i);
                }else
                    teamS.add(i);
            }
            int sumS = 0;
            int sumL = 0;
            for(int i=0; i<N/2; i++){
                for(int j=0; j<N/2; j++){
                    sumS += arr[teamS.get(i)][teamS.get(j)];
                    sumL += arr[teamL.get(i)][teamL.get(j)];
                }
            }
            ans = Math.min(ans,Math.abs(sumS-sumL));
            return;
        }
        for(int i=start; i<N; i++){
            check[i] = true;
            solve(depth+1,i+1);
            check[i] = false;
        }
    }
}
