import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ColorBlindness10026 {
    static int N;
    static char[][] arr;
    static char[][] arr2;
    static Integer[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int check = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        arr2 = new char[N][N];
        visited = new Integer[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j);
                arr2[i][j] = s.charAt(j);
                if(s.charAt(j)=='G')
                    arr2[i][j] = 'R';
            }
        }
        int c = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==null){
                    c++;
                    bfs(i,j,c,arr);
                }
            }
        }
        visited = new Integer[N][N];

        int c2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==null){
                    c2++;
                    bfs(i,j,c2,arr2);
                }
            }
        }

        System.out.println(c+" "+c2);

    }
    static void bfs(int x,int y, int count, char[][] arr){
        Queue<Node10026> q = new LinkedList<>();
        q.add(new Node10026(x,y));
        visited[x][y]=count;
        while(!q.isEmpty()){
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    if(visited[nx][ny] == null){
                        if(arr[nx][ny]==arr[cx][cy]){
                            visited[nx][ny] = count;
                            q.add(new Node10026(nx,ny));
                        }
                    }

                }
            }
        }
    }
}
class Node10026{
    int x,y;
    Node10026(int x,int y){
        this.x=x;
        this.y=y;
    }
}