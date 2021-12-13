import java.util.*;

public class Delivery {
    static int N;
    static int[][] road;
    static int K;
    static int answer;
    static boolean[] check;
    static PriorityQueue<Edge> pq;
    static Edge[] d;
    static List<Edge>[] adj;
    public static void main(String[] args) {
        N = 5;
        road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        K = 3;

        answer = 0;
        pq = new PriorityQueue<>();
        check = new boolean[N+1];
        d = new Edge[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++) {
            adj[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            adj[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }

        dijkstra();

        for (Edge edge : d) {
            if(edge != null && edge.time<=K) {
                answer++;
            }
            System.out.println("edge = " + edge);
        }
        System.out.println(answer);


    }
    static void dijkstra() {
        for(int i=1; i<N+1; i++) {
            if (i==1) { //1번 마을에서 시작
                d[i] = new Edge(i, 0);
            } else {
                d[i] = new Edge(i, Integer.MAX_VALUE);
            }
            pq.add(d[i]);
        }

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            for (Edge next : adj[edge.town]) {
                if(!check[next.town] && d[next.town].time > d[edge.town].time + next.time) {
                    d[next.town].time = d[edge.town].time + next.time;
                    pq.remove(d[next.town]);
                    pq.add(d[next.town]);
                }
            }
            check[edge.town] = true;
        }
    }

    static class Edge implements Comparable<Edge> {
        int town, time;

        public Edge(int town, int time) {
            this.town = town;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "town=" + town +
                    ", time=" + time +
                    '}';
        }
    }
}
