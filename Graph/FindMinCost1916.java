import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FindMinCost1916 {
    static int N, M;
    static List<ArrayList<Edge>> list = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int current = pq.poll().des;
            if (visited[current])
                continue;

            visited[current] = true;
            for (Edge edge : list.get(current)) {
                if (distance[edge.des] > distance[current] + edge.cost) {
                    distance[edge.des] = distance[current] + edge.cost;
                    pq.add(new Edge(edge.des, distance[edge.des]));
                }
            }
        }
        System.out.println(distance[destination]);
    }

    static class Edge implements Comparable<Edge> {
        int des, cost;

        public Edge(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
