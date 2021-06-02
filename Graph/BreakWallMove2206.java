import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWallMove2206 {
    static int N,M,ans;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        ans = Integer.MAX_VALUE;
        bfs();
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(visit[i][j]+" ");
//            }
//            System.out.println();
//        }
        if(ans==Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(ans);

    }
    static void bfs(){
        Queue<NodeB> q = new LinkedList<>();
        q.add(new NodeB(0,0,1,0));
        visit[0][0] = 0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int dis = q.peek().dis;
            int bk = q.peek().bk;
            if(x==N-1 && y==M-1){//도착지점.
                ans = dis;
                break;
            }
            q.poll();
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && visit[nx][ny]>bk){
                    if(arr[nx][ny]==0){//벽이 아닐 때
                        visit[nx][ny] = bk;
                        q.add(new NodeB(nx,ny,dis+1,bk));
                    } else{//벽일 때
                        if(bk==0){ //지금까지 벽을 안부셨으면
                            visit[nx][ny] = bk+1;
                            q.add(new NodeB(nx,ny,dis+1,bk+1));
                        }
                    }
                }
            }
        }
    }
}
class NodeB{
    int x,y,dis,bk; //dis는 거리, bk는 벽을 부순 횟수
    NodeB(int x, int y, int dis, int bk){
        this.x=x;
        this.y=y;
        this.dis = dis;
        this.bk = bk;
    }
}
