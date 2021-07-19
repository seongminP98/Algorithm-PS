import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NetworkConnection1922 {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost,o2.cost); //오름차순
            }
        });
        parent = new int[N+1];
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }
        int ans = 0;
        for(int i=0; i<M; i++){
            Edge edge = edges.get(i);
            if(!isSameParent(edge.s, edge.e)){
                union(edge.s,edge.e);
                ans += edge.cost;
            }
        }
        System.out.println(ans);

    }
    static int find(int x){
        if(parent[x] == x)
            return x;
        else{
            return parent[x] = find(parent[x]);
        }
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        return x==y;
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[y]=x;
        }
    }

    static class Edge{
        int s,e,cost;
        Edge(int s, int e, int cost) {
            this.s=s;
            this.e=e;
            this.cost=cost;
        }
    }
}
