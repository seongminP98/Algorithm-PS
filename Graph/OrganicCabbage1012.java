import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage1012 {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
            sb.append(ans).append('\n');
            ans=0;
        }
        System.out.print(sb);
    }
    static void bfs(int i,int j){
        Queue<NodeCab> q = new LinkedList<>();
        q.add(new NodeCab(i,j));
        visited[i][j] = true;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[nx][ny] && map[nx][ny]==1){
                    q.add(new NodeCab(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        ans++;
    }
}
class NodeCab{
    int x;
    int y;
    NodeCab(int x , int y){
        this.x=x;
        this.y=y;
    }
}
