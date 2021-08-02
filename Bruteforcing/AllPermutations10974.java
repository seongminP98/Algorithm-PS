import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AllPermutations10974 {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N];
        sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            visited[i] = true;
            dfs(0,i);
            visited[i] = false;
        }
        System.out.println(sb);
    }
    static void dfs(int depth, int start){
        arr[depth] = start+1;
        if(depth==N-1) {
            for(int i=0; i<N; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,i);
                visited[i] = false;
            }
        }
    }
}
