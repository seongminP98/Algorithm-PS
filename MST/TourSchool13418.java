import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TourSchool13418 {
    static int[] parent;
    static List<Edge> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + 1; // 출발지까지 노드 +1
        int M = Integer.parseInt(st.nextToken()) + 1;

        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken()); // 0: 오르막길, 1: 내리막길
            list.add(new Edge(A, B, C));
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Collections.sort(list); // cost 오름차순 정렬

        int worst = 0;
        for (int i = 0; i < M; i++) {
            Edge edge = list.get(i);
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                if (edge.cost == 0) {
                    worst++;
                }
            }
        }

        int best = 0;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = M - 1; i >= 0; i--) {
            Edge edge = list.get(i);
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                if (edge.cost == 0) {
                    best++;
                }
            }
        }

        System.out.println(worst * worst - best * best);

    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int s, e, cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
