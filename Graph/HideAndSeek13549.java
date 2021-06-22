import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek13549 {
    static int N,K;
    static boolean[] visited = new boolean[100001];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.print(ans);
    }
    static void bfs(){
        Queue<Node13549> q = new LinkedList<>();
        q.offer(new Node13549(0,N));
        while(!q.isEmpty()){
            int time = q.peek().time;
            int p = q.peek().p;
            q.poll();
            visited[p] = true;
            if(p==K){
                ans = Math.min(ans,time);
            }
            int[] next = {p-1,p+1,p*2};
            for(int i=0; i<3; i++){
                if(next[i]<=100000 && next[i] >= 0 && !visited[next[i]] ){
                    if(i==2){
                        q.offer(new Node13549(time,next[i]));
                    }else{
                        q.offer(new Node13549(time+1,next[i]));
                    }

                }
            }
        }
    }
}
class Node13549{
    int time, p;
    Node13549(int time, int p){
        this.time = time;
        this.p = p;
    }
}
