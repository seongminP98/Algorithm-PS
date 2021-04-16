import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BridgeBuilding2146 {
    static int number = 2;
    static int[][] map;
    static int[][] dis;
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dis = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        island();
        distance();

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=0 && ny>=0 && nx<n && ny<n){
                        if(map[i][j]!= map[nx][ny]) //다른 섬에서 설치한 다리가 만난 경우
                            ans = Math.min(ans,dis[i][j]+dis[nx][ny]); //그 서로 다른 섬에서 설치한 다리 개수의 합.
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static void island(){ //섬 구분.
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1){
                    map[i][j] = number;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()) {
                        int cx = q.peek()[0];
                        int cy = q.peek()[1];
                        q.poll();
                        for(int k=0; k<4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<n){
                                if(map[nx][ny]==1){
                                    map[nx][ny] = number;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    number++;
                }
            }
        }
    }
    static void distance(){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dis[i][j]=-1;
                if(map[i][j]>0){
                    q.add(new int[]{i,j});
                    dis[i][j]=0;//섬이 있는 곳은 거리가 0이므로 0으로 초기화.
                }
            }
        }
        while(!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(dis[nx][ny]==-1){
                        dis[nx][ny] = dis[cx][cy]+1; //다리 한칸 설치.
                        map[nx][ny]=map[cx][cy]; //어떤섬에서 다리를 설치했는지 보여줌.
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
