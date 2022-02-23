import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P16236 {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Node start;
    static int size;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    start = new Node(i, j, 0);
                    arr[i][j] = 0;
                }
            }
        }
        size = 2;
        bfs();
        System.out.println(answer);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        int eatCount = 0;
        while (true) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[][] visited = new boolean[N][N];
            while (!q.isEmpty()) {
                Node c = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        if (arr[nx][ny] <= size) {
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny, c.time + 1));
                            if (arr[nx][ny] > 0 && arr[nx][ny] < size) {
                                pq.add(new Node(nx, ny, c.time + 1));
                            }
                        }
                    }
                }
            }
            if (pq.isEmpty()) {
                return;
            }

            Node next = pq.poll();

            arr[next.x][next.y] = 0;
            eatCount++;
            answer += next.time;

            if (eatCount == size) {
                size++;
                eatCount = 0;
            }
            q.add(new Node(next.x, next.y, 0));
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if (time == o.time) {
                if (x == o.x) {
                    return Integer.compare(y, o.y);
                }
                return Integer.compare(x, o.x);
            }
            return Integer.compare(time, o.time);
        }
    }
}
