import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backdoor17396 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<ArrayList<Edge>> list = new ArrayList<>();
        boolean[] check = new boolean[N]; // 시야
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            check[i] = st.nextToken().charAt(0) == '0';
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.get(a).add(new Edge(b, t));
            list.get(b).add(new Edge(a, t));
        }
        Long[] distance = new Long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        distance[0] = 0L;
        while (!pq.isEmpty()) {
            int current = pq.poll().end;
            if (visited[current])
                continue;
            visited[current] = true;
            for (Edge edge : list.get(current)) {
                if (edge.end != N - 1 && check[edge.end]) {
                    if (distance[edge.end] > distance[current] + edge.cost) {
                        distance[edge.end] = distance[current] + edge.cost;
                        pq.add(new Edge(edge.end, distance[edge.end]));
                    }
                } else if (edge.end == N - 1) {
                    if (distance[edge.end] > distance[current] + edge.cost) {
                        distance[edge.end] = distance[current] + edge.cost;
                        pq.add(new Edge(edge.end, distance[edge.end]));
                    }
                }
            }
        }
        if (distance[N - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(distance[N - 1]);
        }

    }

    static class Edge implements Comparable<Edge> {
        int end;
        long cost;

        public Edge(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            if (cost < o.cost) return -1;
            else return 1;
        }
    }
}
