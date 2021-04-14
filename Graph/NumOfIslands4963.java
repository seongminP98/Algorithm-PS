import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumOfIslands4963 {
    static int[][] map;
    static int count;
    static int[] dx = {1,1,1,-1,-1,-1,0,0};
    static int[] dy = {0,1,-1,0,1,-1,1,-1};
    static int h;
    static int w;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            count=0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0)
                break;

            map = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]==1){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(count);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void dfs(int x,int y){
        map[x][y]=0;
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<h && ny<w){
                if(map[nx][ny]==1){
                    dfs(nx,ny);
                }
            }
        }
    }
}
