import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FindMinCost11779 {
    static int N, M;
    static List<ArrayList<Edge>> list = new ArrayList<>();

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
        int end = Integer.parseInt(st.nextToken());
        int[] route = new int[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            int current = pq.poll().des;
            if (visited[current])
                continue;

            visited[current] = true;

            for (Edge edge : list.get(current)) {
                if (distance[edge.des] > distance[current] + edge.cost) {
                    distance[edge.des] = distance[current] + edge.cost;
                    route[edge.des] = current; //이 정점 오기 직전 정점 저장.
                    pq.add(new Edge(edge.des, distance[edge.des]));
                }
            }
        }
        Stack<Integer> answer = new Stack<>(); //스택이용해서 경로 탐색
        int des = end;
        while (true) {
            if (route[des] == start) {
                answer.push(start);
                break;
            }
            des = route[des];
            answer.push(des);

        }
        StringBuilder sb = new StringBuilder();
        sb.append(distance[end]).append('\n');
        sb.append(answer.size() + 1).append('\n');
        while (!answer.isEmpty()) {
            sb.append(answer.pop()).append(" ");
        }
        sb.append(end);
        System.out.println(sb);

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
