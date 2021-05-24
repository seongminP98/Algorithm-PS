import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WalkingBeer9205 {
    static int n;
    static int hx,hy;
    static int arr[][];
    static int fx,fy;
    static String ans;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            ans = "";
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());
            arr = new int[n][2];
            visited = new boolean[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            st =  new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            bfs();
            sb.append(ans).append('\n');

        }
        System.out.println(sb);
    }
    static void bfs(){
        Queue<NodeBeer> q = new LinkedList<>();
        q.add(new NodeBeer(hx,hy));
        if(distance(hx,hy,fx,fy)<=1000){
            ans = "happy";
            return;
        }
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            if(distance(x,y,fx,fy)<=1000){
                ans = "happy";
                return;
            }
            for(int i=0; i<n; i++){
                if(!visited[i] && distance(x,y,arr[i][0],arr[i][1])<=1000){
                    visited[i] = true;
                    q.add(new NodeBeer(arr[i][0],arr[i][1]));
                }
            }
        }
        ans = "sad";
    }
    static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
class NodeBeer{
    int x,y;
    NodeBeer(int x, int y){
        this.x=x;
        this.y=y;
    }
}