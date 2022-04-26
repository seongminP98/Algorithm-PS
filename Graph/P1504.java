import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1504 {
    static List<ArrayList<Edge>> list = new ArrayList<>();
    static int N, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Edge(end, cost));
            list.get(end).add(new Edge(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] start = dijkstra(1);
        int[] startA = dijkstra(a);
        int[] startB = dijkstra(b);
        int sa = start[a];
        int ab = startA[b];
        int be = startB[N];
        int sb = start[b];
        int ba = startB[a];
        int ae = startA[N];
        int case1 = -1;
        int case2 = -1;
        if (sa != Integer.MAX_VALUE && ab != Integer.MAX_VALUE && be != Integer.MAX_VALUE) {
            case1 = sa + ab + be;
        }
        if (sb != Integer.MAX_VALUE && ba != Integer.MAX_VALUE && ae != Integer.MAX_VALUE) {
            case2 = sb + ba + ae;
        }

        System.out.println(case1 == -1 ? case2 : case2 == -1 ? case1 : Math.min(case1, case2));
    }

    static int[] dijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            int current = pq.poll().e;
            if (visited[current])
                continue;

            visited[current] = true;

            for (Edge edge : list.get(current)) {
                if (distance[edge.e] > distance[current] + edge.cost) {
                    distance[edge.e] = distance[current] + edge.cost;
                    pq.add(new Edge(edge.e, distance[edge.e]));
                }
            }
        }
        return distance;
    }

    static class Edge implements Comparable<Edge> {
        int e, cost;

        public Edge(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
