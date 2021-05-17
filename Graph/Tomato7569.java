import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7569 {
    static int M,N,H;
    static int[][][] map;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }
        bfs();

        int answer=0;
        loop: for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    answer = Math.max(map[j][k][i],answer);
                    if(map[j][k][i]==0){
                        answer=0;
                        break loop;
                    }
                }
            }
        }
        answer--;
        System.out.println(answer);
    }
    static void bfs(){
        Queue<NodeTomato> q = new LinkedList<>();
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[j][k][i]==1){
                        q.add(new NodeTomato(j,k,i));
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int z = q.peek().z;
            q.poll();
            for(int i=0; i<6; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                int nz = z+dz[i];
                if(nx>=0 && ny>=0 && nz>=0 && nx<N && ny<M && nz<H && map[nx][ny][nz]==0){
                    q.add(new NodeTomato(nx,ny,nz));
                    map[nx][ny][nz] = map[x][y][z]+1;
                }
            }
        }
    }
}
class NodeTomato{
    int x,y,z;
    NodeTomato(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}
