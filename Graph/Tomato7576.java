import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7576 {
    static int m,n;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        int max=0;
        boolean check= false;
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(max<map[i][j])
                    max = map[i][j];
                if(map[i][j]==0){
                    check = true;
                }
            }
        }
        if(check)
            System.out.print(-1);
        else
            System.out.print(max-1);  //첫날 시작을 0이 아니라 1로 했으니 -1을 해줌.
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){             //1인 토마토를 전부다 큐에 넣음. 동시에 탐색시작.
            for(int j=0; j<m; j++){
                if(map[i][j]==1)
                    q.add(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(map[nx][ny]==0){
                        q.add(new int[]{nx,ny});
                        map[nx][ny]=map[cx][cy]+1; //다음날 익은 토마토는 +1을 해줌. 최대 날짜 계산 위함
                    }
                }


            }
        }
    }
}
