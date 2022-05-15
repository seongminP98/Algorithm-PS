import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TowCoin16197 {
    static int N, M;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'o') {
                    if (q1.isEmpty())
                        q1.add(new Node(i, j, 1));
                    else
                        q2.add(new Node(i, j, 1));
                }
            }
        }
        bfs(q1, q2);
        System.out.println(answer == Integer.MAX_VALUE ? "-1" : answer);
    }

    static void bfs(Queue<Node> q1, Queue<Node> q2) {
        Set<NodeVisit> visited = new HashSet<>();
        visited.add(new NodeVisit(q1.peek().x, q1.peek().y, q2.peek().x, q2.peek().y));
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node c1 = q1.poll();
            Node c2 = q2.poll();
            for (int i = 0; i < 4; i++) {
                int nx1 = c1.x + dx[i];
                int ny1 = c1.y + dy[i];
                int nx2 = c2.x + dx[i];
                int ny2 = c2.y + dy[i];
                if (isOut(nx1, ny1) ^ isOut(nx2, ny2)) {
                    if (isOut(nx1, ny1)) {
                        answer = Math.min(answer, c1.cnt);
                    } else {
                        answer = Math.min(answer, c2.cnt);
                    }
                } else if (!(isOut(nx1, ny1) | isOut(nx2, ny2))) { // 둘 다 범위 안
                    boolean check1 = false;
                    boolean check2 = false;
                    if (arr[nx1][ny1] == '#') {
                        nx1 = c1.x;
                        ny1 = c1.y;
                        check1 = true;
                    }
                    if (arr[nx2][ny2] == '#') {
                        nx2 = c2.x;
                        ny2 = c2.y;
                        check2 = true;
                    }
                    if (check1 & check2) continue;
                    if (!visited.contains(new NodeVisit(nx1, ny1, nx2, ny2)) && c1.cnt < 10) {
                        visited.add(new NodeVisit(nx1, ny1, nx2, ny2));
                        q1.add(new Node(nx1, ny1, c1.cnt + 1));
                        q2.add(new Node(nx2, ny2, c2.cnt + 1));
                    }
                }
            }
        }
    }

    static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    static class NodeVisit {
        int x1, y1, x2, y2;

        public NodeVisit(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "NodeVisit{" +
                    "x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeVisit nodeVisit = (NodeVisit) o;
            return x1 == nodeVisit.x1 &&
                    y1 == nodeVisit.y1 &&
                    x2 == nodeVisit.x2 &&
                    y2 == nodeVisit.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }

    static class Node {
        int x, y, cnt;


        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    '}';
        }
    }

}
