import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GreenZelda4485 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            sb.append("Problem ").append(t++).append(": ");
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] distance = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            distance[0][0] = arr[0][0];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, arr[0][0]));
            while (!pq.isEmpty()) {
                Node c = pq.poll();
                if (visited[c.x][c.y]) {
                    continue;
                }
                visited[c.x][c.y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (distance[nx][ny] > distance[c.x][c.y] + arr[nx][ny]) {
                            distance[nx][ny] = distance[c.x][c.y] + arr[nx][ny];
                            pq.add(new Node(nx, ny, distance[nx][ny]));
                        }
                    }
                }
            }
            sb.append(distance[N - 1][N - 1]).append('\n');
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
