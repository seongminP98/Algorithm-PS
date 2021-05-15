import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory14502 {
    static int N,M;
    static int[][] map;
    static int ans = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0);
        System.out.println(ans);

    }
    static void combination(int depth){
        if(depth == 3){
            BFS();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    combination(depth+1);
                    map[i][j]=0;
                }
            }
        }
    }
    static void BFS(){
        int[][] nMap = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                nMap[i][j] = map[i][j];
            }
        }
        Queue<NodeLab> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(nMap[i][j] == 2){
                    q.add(new NodeLab(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M && nMap[nx][ny]==0){
                    nMap[nx][ny] = 2;
                    q.add(new NodeLab(nx,ny));
                }
            }
        }
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(nMap[i][j]==0){
                    count++;
                }
            }
        }
        ans = Math.max(count,ans);
    }
}
class NodeLab{
    int x;
    int y;
    NodeLab(int x, int y){
        this.x=x;
        this.y=y;
    }
}
