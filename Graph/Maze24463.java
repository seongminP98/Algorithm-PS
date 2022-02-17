import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Maze24463 {
    static int N, M;
    static char[][] arr;
    static Node start, end;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Node[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if ((i == 0 || i == N - 1 || j == 0 || j == M - 1) && start == null) {
                    if (arr[i][j] == '.') {
                        start = new Node(i, j);
                        continue;
                    }
                }
                if ((i == 0 || i == N - 1 || j == 0 || j == M - 1) && start != null) {
                    if (arr[i][j] == '.') {
                        end = new Node(i, j);
                    }
                }
            }
        }
        visited = new Node[N][M];
        bfs();
        int x = end.x;
        int y = end.y;
        arr[x][y] = '1';
        do { //경로 역추적
            Node next = visited[x][y];
            x = next.x;
            y = next.y;
            arr[x][y] = '1';

        } while (x != visited[x][y].x || y != visited[x][y].y);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '.') {
                    arr[i][j] = '@';
                } else if (arr[i][j] == '1') {
                    arr[i][j] = '.';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] chars : arr) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = new Node(start.x, start.y);
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == '.' && visited[nx][ny] == null) {
                    visited[nx][ny] = new Node(x, y); //경로 역추적
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return "x=" + x +
                    ", y=" + y;
        }
    }
}
