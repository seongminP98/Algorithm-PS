import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus2606 {
    static int N,p;
    static LinkedList<Integer>[] map;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        map = new LinkedList[N+1];
        for(int i=0; i<N+1; i++){
            map[i] = new LinkedList<>();
        }
        for(int i=0; i<p; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        bfs();
        System.out.print(ans);

    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i=0; i<map[temp].size(); i++){
                if(visited[map[temp].get(i)])
                    continue;
                q.offer(map[temp].get(i));
                visited[map[temp].get(i)] = true;
                ans++;
            }
        }
    }
}
