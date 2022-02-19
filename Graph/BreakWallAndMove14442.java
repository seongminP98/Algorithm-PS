import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWallAndMove14442 {
    static int N, M, K;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.dis;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 1 && current.count < K && !visited[nx][ny][current.count + 1]) { //벽
                        visited[nx][ny][current.count + 1] = true;
                        q.add(new Node(nx, ny, current.count + 1, current.dis + 1));
                    } else if (arr[nx][ny] == 0 && !visited[nx][ny][current.count]) {
                        visited[nx][ny][current.count] = true;
                        q.add(new Node(nx, ny, current.count, current.dis + 1));
                    }
                }

            }
        }
        return -1;
    }

    static class Node {
        int x, y, count, dis;

        public Node(int x, int y, int count, int dis) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dis = dis;
        }
    }
}
