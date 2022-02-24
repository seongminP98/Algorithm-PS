import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {
    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static List<ArrayList<Edge>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        //출발정점을 인덱스. 도착정점과 가중치를 그 인덱스에 해당하는 리스트에 넣는다.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0)); //시작점은 가중치가 0
        while (!pq.isEmpty()) {
            int current = pq.poll().v; //현재 출발하는 정점. [시작점과 출발점은 다름]
            if (visited[current]) // 이미 출발지로 한 정점은 continue; (다시 되돌아 가면 무한루프)
                continue;

            visited[current] = true;
            //현재 출발하는 정점과 연결된 정점들
            for (Edge edge : list.get(current)) {
                //시작점에서 이 정점까지의 거리가 현재 출발하는 정점을 지나서 가는게 더 짧으면 갱신
                if (distance[edge.v] > distance[current] + edge.w) {
                    distance[edge.v] = distance[current] + edge.w;
                    pq.add(new Edge(edge.v, distance[edge.v])); //갱신된 경우에만 PQ에 넣는다.
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } else {
                sb.append(distance[i]).append('\n');
            }
        }
        System.out.print(sb);


    }

    static class Edge implements Comparable<Edge> { //도착정점, 가중치
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }
}
