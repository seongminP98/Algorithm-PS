import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP10971 {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;
    static int[] weight;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        weight = new int[N];
        visit = new boolean[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            solve(0,i,i,0);
        }
        System.out.println(result);

    }
    static void solve(int count, int start, int current, int sum){ //순열로 모든 경우 계산
        if(count==N && start==current){ //현재값과 시작값이 같은 경우만 고려
            result = Math.min(result,sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                if(arr[current][i]!=0){
                    visit[i] = true;
                    sum += arr[current][i];
                    solve(count+1,start,i,sum);
                    visit[i] = false;
                    sum -= arr[current][i];
                }
            }
        }
    }
}
