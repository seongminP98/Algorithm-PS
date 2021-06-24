
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestDistance1753 {
    static int V,E,K;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge1753>[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        map = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Edge1753(b,c));
        }

        visited = new boolean[V+1];
        distance = new int[V+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V+1; i++){
            if(visited[i])
                sb.append(distance[i]).append('\n');
            else
                sb.append("INF").append('\n');
        }
        System.out.print(sb);

    }
    static void dijkstra(int start){
        PriorityQueue<Edge1753> q = new PriorityQueue<>();
        q.add(new Edge1753(start,0));
        distance[start]=0;

        while(!q.isEmpty()){
            int c = q.peek().end;
            q.poll();
            if(visited[c]){
                continue;
            }
            visited[c] = true;
            for(Edge1753 e : map[c]){
                if(distance[e.end]>distance[c]+e.value){
                    distance[e.end] = distance[c]+e.value;
                    q.add(new Edge1753(e.end,distance[e.end]));
                }
            }
        }
    }
}
class Edge1753 implements Comparable<Edge1753>{ //PriorityQueue에 넣기 때문에 우선순위를 정의해줘야함.
    int end;
    int value;
    Edge1753(int end, int value){
        this.end = end;
        this.value = value;
    }
    @Override
    public int compareTo(Edge1753 o) {
        return value - o.value;
    }
}





