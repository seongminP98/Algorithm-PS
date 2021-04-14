import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Numbering2667 {
    static int[][] map;
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Integer> list = new ArrayList<>();
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            String r = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = r.charAt(j)-'0';
            }
        }
        int total=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1){
                    total++;
                    count=0;
                    list.add(dfs(i,j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(total);
        for(int i : list){
            System.out.println(i);
        }

    }
    static int dfs(int x, int y){
        map[x][y]=0; //찾은건 0으로 바꿔줌.
        count++;
        for(int i=0; i<4; i++){ //오른쪽, 왼쪽, 위, 아래 순으로 찾음.
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n){
                if(map[nx][ny]==1){
                    dfs(nx,ny);
                }
            }
        }
        return count;

    }
}
