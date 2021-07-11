import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SafeZone2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int c = Integer.parseInt(st.nextToken());
                map[i][j] = c;
                if(max<c)
                    max = c;
            }
        }
        int ans = 0;
        for(int h=0; h<max; h++){
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] > h && !visited[i][j]){
                        cnt++;
                        dfs(i,j,h);
                    }
                }
            }
            visited = new boolean[N][N];
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);


    }
    static void dfs(int x, int y, int h){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N){
                if(!visited[nx][ny] && map[nx][ny]>h)
                    dfs(nx,ny,h);
            }
        }
    }
}
