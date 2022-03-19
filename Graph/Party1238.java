import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Party1238 { //시간 : 212ms
    static int N, M, X;
    static List<ArrayList<Edge>> listGo = new ArrayList<>();
    static List<ArrayList<Edge>> listBack = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            listGo.add(new ArrayList<>());
            listBack.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            listBack.get(end).add(new Edge(start, cost));
            listGo.get(start).add(new Edge(end, cost));
        }
        int answer = 0;
        int[] go = dijkstra(listGo);
        int[] back = dijkstra(listBack);
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }
        System.out.println(answer);
    }

    static int[] dijkstra(List<ArrayList<Edge>> list) {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[X] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));
        while (!pq.isEmpty()) {
            int c = pq.poll().e;
            if (visited[c]) {
                continue;
            }
            visited[c] = true;
            for (Edge edge : list.get(c)) {
                if (distance[edge.e] > distance[c] + edge.cost) {
                    distance[edge.e] = distance[c] + edge.cost;
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
/* 시간 : 768ms
//다익스트라는 출발지를 정해주면 출발지에서 모든 정점까지의 최단경로를 구한다.
//길의 정보를 정방향, 역방향 두개의 리스트에 저장하고,
//모든 정점에서 도착지(X)까지의 최단거리는 역방향리스트에 저장하고, 출발지를 X로 설정
//도착지(X)에서 모든 정점까지의 최단거리는 정방향리스트에 저장하고, 출발지를 X로 설정
//이렇게 하면 dijkstra 를 2번만 실행하면 된다. 처음 풀이한 아래 방법은 매 정점에서 X까지 왕복 최단거리를 구하려면
//dijkstra 를 N*2번 실행함. (하지만 여기서도 X에서 모든 정점까지의 최단거리는 한번만 해도 됐음..)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<ArrayList<Edge>> list = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dijkstra(i, X) + dijkstra(X, i));
        }
        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            if (dp[start][i] != 0) {
                distance[i] = dp[start][i];
                visited[i] = true;
            }
        }
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            int c = pq.poll().e;
            if (visited[c]) {
                continue;
            }
            visited[c] = true;
            for (Edge edge : list.get(c)) {
                if (distance[edge.e] > distance[c] + edge.cost) {
                    distance[edge.e] = distance[c] + edge.cost;
                    pq.add(new Edge(edge.e, distance[edge.e]));
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                dp[start][i] = distance[i];
            }
        }
        return distance[end];
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

 */