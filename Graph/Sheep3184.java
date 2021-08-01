import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sheep3184 {
    static int R,C;
    static char[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int sumO = 0;
    static int sumV = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '#')
                    bfs(i, j);
            }
        }
        System.out.println(sumO+" "+sumV);
    }
    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        int vCnt = 0;
        int oCnt = 0;
        if(arr[x][y]=='v'){
            vCnt++;
        }
        if(arr[x][y]=='o'){
            oCnt++;
        }
        arr[x][y]='#';
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<R && ny<C) {
                    if(arr[nx][ny] == '#')
                        continue;
                    if(arr[nx][ny] == 'o'){
                        oCnt++;
                    } else if(arr[nx][ny] == 'v'){
                        vCnt++;
                    }
                    arr[nx][ny] = '#';
                    q.add(new Node(nx,ny));
                }
            }
        }
        if(oCnt>vCnt){
            sumO += oCnt;
        } else{
            sumV += vCnt;
        }

    }
    static class Node{
        int x,y;
        Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
