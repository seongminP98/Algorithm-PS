import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino14500 {
    static int N,M;
    static int[][] arr;
    static int ans = Integer.MIN_VALUE;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dfs(0,0,i,j);
                other(i,j);
            }
        }
        System.out.println(ans);

    }
    static void dfs(int depth, int sum, int x, int y){
        if(depth == 4){
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(depth+1,sum+arr[nx][ny],nx,ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    static void other(int x, int y){ //ㅗ 모양
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];
        for(int i=0; i<4; i++){ //x,y를 기준으로 상하좌우 4개를 다 계산. 마지막에 하나를 뺌.
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(wing<=2) //2개가 범위에 있지 않으면 ㅗ 모양이 아니다.
                return;
            if(nx<0 || ny<0 || nx>=N || ny>=M){ //한칸이 범위에 있지 않으면 그걸 뺀다.
                wing--;
                continue;
            }
            min = Math.min(min,arr[nx][ny]); //ㅗ 모양을 하기 위해 한칸을 뺀다. (가장 작은값 빼야함)
            sum = sum + arr[nx][ny];
        }
        if(wing==4){
            sum = sum-min;
        }
        ans = Math.max(ans,sum);
    }
}
