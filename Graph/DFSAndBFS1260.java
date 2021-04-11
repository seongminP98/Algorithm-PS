import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSAndBFS1260 {
    static int map[][];
    static boolean[] visit;
    static int N,M,V;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b]=1;
            map[b][a]=1;
        }
        dfs(V);
        System.out.println();
        Arrays.fill(visit,false);
        bfs(V);
    }
    static void dfs(int i){
        visit[i] = true;
        System.out.print(i+" ");
        for(int j=1; j<N+1; j++){
            if(map[i][j] == 1 && !visit[j]){
                dfs(j);
            }
        }
    }
    static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");

            for(int k=1; k<=N; k++){
                if(map[temp][k]==1 && !visit[k]){
                    queue.add(k);
                    visit[k]=true;
                }
            }
        }
    }
}
