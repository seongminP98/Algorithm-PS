import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WhyCowCrossRoad14466 {
    static int N, K, R;
    static Set<Road> road;
    static Set<Node> cow;
    static int answer = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        road = new HashSet<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            road.add(new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        cow = new HashSet<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cow.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (Node node : cow) {
            answer += bfs(node.x, node.y);
        }
        System.out.println(answer / 2);
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        boolean[][] visited = new boolean[N + 1][N + 1];
        int count = K - 1;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx > 0 && nx <= N && ny > 0 && ny <= N && !visited[nx][ny]) {
                    if (road.contains(new Road(current.x, current.y, nx, ny)) || road.contains(new Road(nx, ny, current.x, current.y))) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    if (cow.contains(new Node(nx, ny))) {
                        count--;
                    }
                }
            }
        }
        return count;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Road {
        int r1, c1, r2, c2;

        public Road(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return r1 == road.r1 &&
                    c1 == road.c1 &&
                    r2 == road.r2 &&
                    c2 == road.c2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r1, c1, r2, c2);
        }
    }
}
