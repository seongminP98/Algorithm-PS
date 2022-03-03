import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CompetitiveContagion18405 {
    static int N, K, S;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0)
                    q.add(new Node(i, j, arr[i][j], 0));
            }
        }
        Collections.sort((List<Node>) q);
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(arr[X][Y]);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.sec == S) { //정렬했기 때문에 1부터 차례로 시작함.
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && arr[nx][ny] == 0) {
                    arr[nx][ny] = c.value;
                    q.add(new Node(nx, ny, c.value, c.sec + 1));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, value, sec;

        public Node(int x, int y, int value, int sec) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}
