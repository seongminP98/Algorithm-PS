import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandMOne15649 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        solve(0);
    }
    static void solve(int depth){
        if(depth==M){
            for(int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                solve(depth+1);
                visited[i] = false;
            }

        }
    }
}
