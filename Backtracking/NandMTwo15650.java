import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandMTwo15650 {
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        solve(0,0);
    }
    static void solve(int depth, int start){
        if(depth==M){
            for(int i=0; i<N; i++){
                if(visited[i])
                    System.out.print(i+1+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                solve(depth+1, i+1);
                visited[i] = false;
            }

        }
    }
}
