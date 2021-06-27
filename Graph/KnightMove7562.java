import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMove7562 {
    static int I;
    static Integer[][] arr;
    static int gx,gy;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            I = Integer.parseInt(br.readLine());
            arr = new Integer[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 0;
            st = new StringTokenizer(br.readLine());
            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());
            bfs(a,b);

            sb.append(arr[gx][gy]).append('\n');
        }
        System.out.print(sb);
    }
    static void bfs(int x, int y){
        Queue<Node7562> q = new LinkedList<>();
        q.add(new Node7562(x,y));
        while(!q.isEmpty()){
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            if(cx==gx && cy==gy){
                break;
            }
            for(int i=0; i<8; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<I && ny<I){
                    if(arr[nx][ny] == null){
                        q.add(new Node7562(nx,ny));
                        arr[nx][ny] = arr[cx][cy]+1;
                    }
                }
            }

        }

    }
}
class Node7562{
    int x,y;
    Node7562(int x, int y){
        this.x=x;
        this.y=y;

    }
}
