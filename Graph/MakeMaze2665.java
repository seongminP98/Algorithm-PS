import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MakeMaze2665 {
    static int n;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j)-'0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(visited[n-1][n-1]);
    }
    static void bfs(){
        Queue<Node2665> q = new LinkedList<>();
        q.add(new Node2665(0,0));
        visited[0][0]=0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]>visited[x][y]){
                    if(map[nx][ny] == 1){
                        q.add(new Node2665(nx,ny));
                        visited[nx][ny] = visited[x][y];
                    } else{
                        q.add(new Node2665(nx,ny));
                        visited[nx][ny] = visited[x][y]+1;
                    }
                }
            }
        }

    }
}
class Node2665{
    int x,y;
    Node2665(int x, int y){
        this.x = x;
        this.y = y;
    }
}