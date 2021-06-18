import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlowerRoad14620 {
    static int ans = Integer.MAX_VALUE;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int N;
    static int[][] arr;
    static int[][] price;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        price = new int[N][N];
        visited = new boolean[N][N];


        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                price[i][j] = arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j-1]+arr[i][j+1];
            }
        }

        sol(0,0);
        System.out.print(ans);

    }
    static void sol(int depth,int sum){
        if(depth==3){
            ans = Math.min(ans,sum);
            return;
        }
        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(!visited[i][j]){
                    boolean check = true;
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(visited[nx][ny]){
                            check = false;
                        }
                    }
                    if(check){
                        visited[i][j] = true;
                        for(int k=0; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            visited[nx][ny] = true;
                        }
                        sol(depth+1, sum+price[i][j]);
                        visited[i][j] = false;
                        for(int k=0; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            visited[nx][ny] = false;
                        }
                    }
                }
            }
        }
    }
}
