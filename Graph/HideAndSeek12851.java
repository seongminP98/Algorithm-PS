import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek12851 {
    static int N,K;
    static boolean[] visited;
    static int count;
    static int[] time;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        time = new int[100001];
        count = 1;
        time[N] = 0;
        bfs();

        System.out.println(min);
        System.out.println(count);
    }
    static void bfs(){
        Queue<Node12851> q = new LinkedList<>();
        q.offer(new Node12851(0,N));
        visited[N] = true;
        while(!q.isEmpty()){
            int tempT = q.peek().time;
            int tempP = q.peek().p;
            q.poll();
            visited[tempP] = true;
            if(tempP == K){
                if(min > tempT){
                    min = tempT;
                } else if(min == tempT){
                    count++;
                }
            }
            int[] next = {tempP+1,tempP-1,tempP*2};

            for(int i=0; i<3; i++){
                if(next[i]>=0 && next[i]<=100000 && !visited[next[i]]){
                    q.offer(new Node12851(tempT+1,next[i]));
                }
            }
        }
    }
}
class Node12851{
    int time;
    int p;
    Node12851(int time, int p){
        this.time = time;
        this.p = p;
    }
}