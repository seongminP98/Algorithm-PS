import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Travel2157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
//        Route[] routes = new Route[K];
        PriorityQueue<Route> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            if (s < e) {
                pq.add(new Route(s, e, score));
            }
        }

        Integer[][] answer = new Integer[M + 1][N + 1]; // 이동 수, 도시 수
        answer[1][1] = 0;
        while (!pq.isEmpty()) {
            Route c = pq.poll();
            for (int i = 1; i < M; i++) {
                if (answer[i][c.s] != null) {
                    if (answer[i + 1][c.e] == null) {
                        answer[i + 1][c.e] = answer[i][c.s] + c.score;
                    } else {
                        answer[i + 1][c.e] = Math.max(answer[i + 1][c.e], answer[i][c.s] + c.score);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 2; i <= M; i++) {
            if (answer[i][N] == null) continue;
            ans = Math.max(answer[i][N], ans);
        }
        System.out.println(ans);

    }

    private static class Route implements Comparable<Route> {
        int s, e, score;

        public Route(int s, int e, int score) {
            this.s = s;
            this.e = e;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "s=" + s +
                    ", e=" + e +
                    ", score=" + score +
                    '}';
        }

        @Override
        public int compareTo(Route o) {
            return Integer.compare(s, o.s);
        }
    }
}
