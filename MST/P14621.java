import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P14621 {
    static int N, M;
    static boolean[] university;
    static List<Edge> list;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        university = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (st.nextToken().equals("M")) {
                university[i] = true;
            }
        }

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (university[u] != university[v]) {
                list.add(new Edge(u, v, d));
            }
        }

        list.sort(Comparator.comparingInt(o -> o.w));
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        int count = 0;
        for (Edge edge : list) {
            if (!isSameParent(edge.s, edge.e)) {
                union(edge.s, edge.e);
                answer += edge.w;
                count++;
            }
        }
        System.out.println(count == N - 1 ? answer : -1);
    }

    private static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    private static boolean isSameParent(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        return x == y;
    }

    private static class Edge {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
