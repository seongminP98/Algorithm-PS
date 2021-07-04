import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jump1890 {
    static int n;
    static int[][] arr;
    //static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        //visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long dp[][] = new long[n][n];
        dp[0][0]=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==n-1 && j==n-1)
                    continue;

                if(i+arr[i][j]<n){
                    dp[i+arr[i][j]][j] += dp[i][j];
                }
                if(j+arr[i][j]<n){
                    dp[i][j+arr[i][j]] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);

    }
//    static void bfs(){
//        Queue<Node1890> q = new LinkedList<>();
//        q.add(new Node1890(0,0));
//        visited[0][0] = true;
//        while(!q.isEmpty()){
//            int x = q.peek().x;
//            int y = q.peek().y;
//            q.poll();
//            //System.out.println("x:"+x+"  y:"+y);
//            int nx = x+arr[x][y];
//            int ny = y+arr[x][y];
//            if(nx>=0 && nx<n){
//                if(nx==n-1 && y==n-1){
//                    ans++;
//                }
//                if(arr[nx][y]!=0){
//                    q.add(new Node1890(nx,y));
//                }
//            }
//            if(ny>=0 && ny<n){
//                if(x==n-1 && ny==n-1){
//                    ans++;
//                }
//                if(arr[x][ny]!=0){
//                    q.add(new Node1890(x,ny));
//                }
//            }
//        }
//
//    }
}
//class Node1890{
//    int x,y;
//    Node1890(int x,int y){
//        this.x=x;
//        this.y=y;
//    }
//}
