import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ChickenDel15686 {
    static int M,N;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<NodeChi> chicken;
    static ArrayList<NodeChi> house;
    static Stack<NodeChi> selectChichen;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        selectChichen = new Stack<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    house.add(new NodeChi(i,j));
                }else if(arr[i][j]==2){
                    chicken.add(new NodeChi(i,j));
                }
            }
        }
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int start, int depth){
        if(depth==M){
            solve();
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            selectChichen.push(chicken.get(i));
            dfs(i+1,depth+1);
            selectChichen.pop();
        }

    }
    static void solve(){
        int t = 0;
        for(NodeChi h : house){
            int min_d = Integer.MAX_VALUE;
            for(NodeChi c : selectChichen){
                int d = distance(h.x,h.y,c.x,c.y);
                min_d = Math.min(min_d,d);
            }
            t+=min_d;
        }
        answer = Math.min(t,answer);

    }
    static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
class NodeChi{
    int x,y;
    NodeChi(int x, int y){
        this.x=x;
        this.y=y;
    }
}
