import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dial2186 {
    static char[][] map;
    static int[][][] visited;
    static int N, M, K;
    static String goal;
    static int count = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        goal = br.readLine();
        visited = new int[N][M][goal.length()]; //dp로 이용
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Arrays.fill(visited[i][j],-1); //아직 방문 안한곳은 -1
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == goal.charAt(0)){ //시작점
                    count += find(0,i,j);
                }
            }
        }
        System.out.println(count);

    }
    static int find(int index, int x, int y){ //DFS
        if(visited[x][y][index] != -1) return visited[x][y][index]; //방문 했으면 저장했던 값 사용
        if(index == goal.length()-1){ //마지막 문자열
            visited[x][y][index] = 1;
            return 1;
        }
        visited[x][y][index] = 0; //일단 방문 한곳은 0으로
        int nx = 0;
        int ny = 0;
        for(int i=0; i<4; i++){
            for(int j=1; j<=K; j++){
                nx = x+dx[i]*j;
                ny = y+dy[i]*j;
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(map[nx][ny] == goal.charAt(index+1)){ //방문할 곳이 goal과 일치한다면
                        System.out.println(visited[x][y][index]+" index:"+index+" x:"+x+" y:"+y);
                        visited[x][y][index] += find(index+1,nx,ny); //
                    }
                }
            }
        }
        return visited[x][y][index];
    }
}
