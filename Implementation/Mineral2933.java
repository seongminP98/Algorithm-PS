import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Mineral2933 {
    static int R, C;
    static boolean[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'x') {
                    arr[i][j] = true;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = R - Integer.parseInt(st.nextToken());
            boolean flag = false;
            int x = 0, y = 0;
            if (i % 2 == 1) { // 왼쪽
                for (int j = 0; j < C; j++) {
                    if (arr[h][j]) {
                        arr[h][j] = false;
                        flag = true;
                        x = h;
                        y = j;
                        break;
                    }
                }
            } else { // 오른쪽
                for (int j = C - 1; j >= 0; j--) {
                    if (arr[h][j]) {
                        arr[h][j] = false;
                        flag = true;
                        x = h;
                        y = j;
                        break;
                    }
                }
            }

            if (flag) {
                for (int k = 0; k < 4; k++) {
                    Queue<Node> q = new LinkedList<>();
                    boolean[][] visited = new boolean[R][C];
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < R - 1 && ny >= 0 && ny < C && arr[nx][ny]) { // 맨 아래는 넣을 필요 없음
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;

                    }
                    if (!q.isEmpty()) {
                        bfs(q, visited);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    sb.append('x');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void bfs(Queue<Node> q, boolean[][] visited) {
        List<Node> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Node c = q.poll();
            list.add(c);
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] && !visited[nx][ny]) {
                    if (nx == R - 1) return;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        list.sort(Collections.reverseOrder());// 아래있는거 먼저
        Set<Integer> check = new HashSet<>();
        int min = R;

        for (Node node : list) {
            if (check.contains(node.y)) continue;

            check.add(node.y);
            int cnt = 0;
            for (int i = node.x + 1; i < R; i++) {
                if (!arr[i][node.y]) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt < min) min = cnt;
        }

        List<Node> mi = new ArrayList<>();
        for (Node node : list) {
            mi.add(new Node(node.x + min, node.y));
            arr[node.x][node.y] = false;
        }
        for (Node node : mi) {
            arr[node.x][node.y] = true;
        }
    }

    private static class Node implements Comparable<Node> {
        int x, y;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(x, o.x);
        }
    }
}
