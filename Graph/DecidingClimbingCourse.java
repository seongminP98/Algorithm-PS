import java.util.*;

public class DecidingClimbingCourse {
    static List<List<Edge>> list;
    static Set<Integer> summitsSet;
    static Set<Integer> gatesSet;
    static int minIntensity = 10_000_000;
    static int answerSummit = 0;
    static int[] dp;

    public static void main(String[] args) {
//        int n = 6;
//        int n = 7;
        int n = 2;
//        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
        int[][] paths = {{1, 2, 4}};
//        int[] gates = {1, 3};
//        int[] gates = {1};
        int[] gates = {1};
//        int[] summits = {5};
//        int[] summits = {2, 3, 4};
        int[] summits = {2};
        System.out.println(Arrays.toString(solution(n, paths, gates, summits)));
    }

    private static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            list.get(path[0]).add(new Edge(path[1], path[2]));
            list.get(path[1]).add(new Edge(path[0], path[2]));
        }
        summitsSet = new HashSet<>();
        gatesSet = new HashSet<>();

        for (int summit : summits) {
            summitsSet.add(summit);
        }
        for (int gate : gates) {
            gatesSet.add(gate);
        }

        dp = new int[n + 1];
        Arrays.fill(dp, 10_000_000);

        for (int gate : gates) {
            boolean[] visited = new boolean[n + 1];
            visited[gate] = true;
            dfs(gate, visited, 0);
        }

        answer[0] = answerSummit;
        answer[1] = minIntensity;
        return answer;
    }

    private static void dfs(int node, boolean[] visited, int intensity) {
        if (summitsSet.contains(node)) {
            System.out.println("node = " + node + " intensity = " + intensity);
            if (minIntensity > intensity) {
                minIntensity = intensity;
                answerSummit = node;
            } else if (minIntensity == intensity) {
                answerSummit = Math.min(answerSummit, node);
            }
            return;
        }
        for (Edge edge : list.get(node)) {
            if (gatesSet.contains(edge.node)) continue;
            if (visited[edge.node]) continue;
            if (minIntensity < edge.w) continue;
            System.out.println("edge = " + edge);

            if (dp[edge.node] < edge.w) continue;

            dp[edge.node] = edge.w;
            visited[edge.node] = true;
            dfs(edge.node, visited, Math.max(intensity, edge.w));
            visited[edge.node] = false;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int node, w;

        public Edge(int node, int w) {
            this.node = node;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + node +
                    ", w=" + w +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
