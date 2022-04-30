import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MineralT18500 {
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
                if (s.charAt(j) == 'x') { // 미네랄 true
                    arr[i][j] = true;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = R - Integer.parseInt(st.nextToken()); // 위에서부터 세기 위함.
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

            if (flag) { // 부셨으면
                for (int k = 0; k < 4; k++) { // 4방 탐색.
                    Queue<Node> q = new LinkedList<>();
                    boolean[][] visited = new boolean[R][C];
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < R - 1 && ny >= 0 && ny < C && arr[nx][ny]) { // 맨 아래는 넣을 필요 없음
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;

                    }
                    if (!q.isEmpty()) {
                        if(bfs(q, visited)) break; // 떨궜으면 종료
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

    private static boolean bfs(Queue<Node> q, boolean[][] visited) {
        Set<Node> set = new HashSet<>(); // 떨어뜨릴 클러스터 저장
        while (!q.isEmpty()) {
            Node c = q.poll();
            set.add(c);
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] && !visited[nx][ny]) {
                    if (nx == R - 1) return false; // 바닥까지 갔으면 떨어뜨릴 수 없음
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        int min = R; // 떨어질 수 있는 최대 높이(미네랄 or 바닥과 가장 가까운 높이)

        for (Node node : set) {
            int cnt = 0;
            for (int i = node.x + 1; i < R; i++) {
                if (!arr[i][node.y]) {
                    cnt++;
                } else {
                    if(set.contains(new Node(i, node.y))) continue; // 중간에서 걸칠 시 그게 내 클러스트인지 아닌지 확인.
                    break;
                }
            }
            if(cnt==0) continue;
            if (cnt < min) min = cnt;
        }

        List<Node> nextMR = new ArrayList<>();
        for (Node node : set) {
            nextMR.add(new Node(node.x + min, node.y)); // 떨어질 자리
            arr[node.x][node.y] = false; // 원래 있던 자리는 빈칸으로
        }
        for (Node node : nextMR) {
            arr[node.x][node.y] = true;
        }

        return true;
    }

    private static class Node {
        int x, y;

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

    }
}
