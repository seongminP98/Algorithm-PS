import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink5014 {
    static int F,S,G,U,D;
    static Integer[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new Integer[F+1];
        bfs();

        if(visited[G]==null){
            System.out.println("use the stairs");
        } else{
            System.out.println(visited[G]);
        }
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S]=0;
        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i=0; i<2; i++){
                int next = temp;
                if(i==0){
                    next += U;
                } else{
                    next -= D;
                }
                if(next>=1 && next<=F && visited[next]==null){
                    q.add(next);
                    visited[next] = visited[temp]+1;
                }
            }
        }
    }
}
