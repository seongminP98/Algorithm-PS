import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MST1197 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        int ans = 0;

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        edges.sort(new Comparator<Edge>() { //크루스칼 알고리즘
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost,o2.cost);
            }
        });
        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }

        for(int i=0; i<E; i++){
            Edge edge = edges.get(i);
            if(!isSameParent(edge.s, edge.e)){
                union(edge.s,edge.e);
                ans += edge.cost;
            }
        }
        System.out.println(ans);

    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        } else{
            return parent[x] = find(parent[x]); //재귀로 부모를 찾으면서 사이클 확인
        }
    }

    public static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y){
            return true;
        } else{
            return false;
        }
    }

    public static void union(int x, int y){
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
