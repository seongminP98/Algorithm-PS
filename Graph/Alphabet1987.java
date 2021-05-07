import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet1987 {
    static int R,C;
    static char[][] arr;
    static boolean[] visited;
    static int ans = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        visited = new boolean[26];
        solve(0,0,1);
//        for(int i=0; i<26; i++){
//            System.out.println(i+" :"+visited[i]);
//        }
        System.out.println(ans);
    }
    static void solve(int x, int y, int count){
        visited[arr[x][y]-'A'] = true;
        ans = Math.max(ans,count);
        //System.out.println("visitied:"+(arr[x][y]-'A')+"x:"+x+" y:"+y);
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            //System.out.println("1nx:"+nx+" ny:"+ny);
            if(nx>=0 && ny>=0 && nx<R && ny<C){
                if(!visited[arr[nx][ny]-'A']){
                    //System.out.println("nx:"+nx+" ny:"+ny);
                    solve(nx,ny,count+1);
                }
            }
        }
        visited[arr[x][y]-'A'] = false;
    }
}
