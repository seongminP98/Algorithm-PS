import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AlgoSpot1261 {
    static int M, N;
    static int[][] maze;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = s.charAt(j)-'0';
            }
        }
        for(int i=0; i<visited.length; i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        bfs();
        System.out.println(visited[N-1][M-1]);
    }
    static void bfs(){
        Queue<AlgoNode> q = new LinkedList<>();
        q.add(new AlgoNode(0,0));
        visited[0][0]=0;

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    //다음 갈 칸이 벽이면서, 방문하지않았거나 방문했지만 최적화 된 값이 아닐 때.
                    if(maze[nx][ny] == 1 && (visited[nx][ny] == Integer.MAX_VALUE || visited[nx][ny]>visited[x][y]+1)){
                        visited[nx][ny] = visited[x][y]+1;
                        q.add(new AlgoNode(nx,ny));
                    }
                    else if(maze[nx][ny] == 0 && (visited[nx][ny] == Integer.MAX_VALUE || visited[nx][ny]>visited[x][y])){
                        visited[nx][ny] = visited[x][y];
                        q.add(new AlgoNode(nx,ny));
                    }
                }
            }
        }
    }
}
class AlgoNode{
    int x;
    int y;
    AlgoNode(int x, int y){
        this.x=x;
        this.y=y;
    }
}
