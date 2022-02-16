import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CityDivPlan1647 {
    static int N, M;
    static Road[] road;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        road = new Road[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            road[i] = new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(road, ((o1, o2) -> {
            return o1.cost - o2.cost;
        }));
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        int max = 0;
        for (int i = 0; i < M; i++) {
            if (!isSameParent(road[i].s, road[i].e)) {
                union(road[i].s, road[i].e);
                answer += road[i].cost;
                max = road[i].cost;
            }
        }
        System.out.println(answer - max);

    }

    static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    static void union(int x, int y) {
        /**
         * if (findParent(x) != findParent(y)) {
         *             parent[y] = x;
         *         }
         *         이렇게 쓰면 안됨!
         */
        x = findParent(x);
        y = findParent(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    static class Road {
        int s, e, cost;

        public Road(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

    }
}
