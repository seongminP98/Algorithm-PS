import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {
    static int w, h;
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            bfs();
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> fire = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == '@') {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                } else if (arr[i][j] == '*') {
                    fire.add(new Node(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = fire.size();
            while (size-- > 0) {
                Node c = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == '.') {
                        arr[nx][ny] = '*';
                        fire.add(new Node(nx, ny, 0));
                    }
                }
            }
            size = q.size();
            while (size-- > 0) {
                Node c = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (arr[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            arr[nx][ny] = '.';
                            q.add(new Node(nx, ny, c.count + 1));
                        }

                    } else {
                        sb.append(c.count + 1).append('\n');
                        return;
                    }
                }
            }


        }
        sb.append("IMPOSSIBLE").append('\n');

    }

    private static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}
