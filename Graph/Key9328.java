import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Key9328 {
    static int h, w;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr = new char[h + 2][w + 2];
            for(int i=0; i<h+2; i++) {
                Arrays.fill(arr[i],'.');
            }
            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= w; j++) {
                    arr[i][j] = s.charAt(j-1);
                }
            }
            int key = 0;
            String k = br.readLine();
            if (!(k.equals("0"))) {
                for (int i = 0; i < k.length(); i++) {
                    key = (1 << k.charAt(i) - 'a') | key;
                }
            }
            System.out.println(bfs(key));
        }
    }

    private static int bfs(int key) {
        int cnt = 0;
        int[][] visited = new int[h + 2][w + 2];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        for (int i = 0; i < h + 2; i++) {
            for (int j = 0; j < w + 2; j++) {
                visited[i][j] = -1;
            }
        }
        visited[0][0] = key;
        // key 는 얻을수록 증가함.
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < h + 2 && ny >= 0 && ny < w + 2) {
                    if (arr[nx][ny] == '.' && visited[nx][ny] != key) {
                        visited[nx][ny] = key;
                        q.add(new Node(nx, ny));
                    } else if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'z' && visited[nx][ny] != key) {
                        key = (1 << arr[nx][ny] - 'a') | key;
                        visited[nx][ny] = key;
                        arr[nx][ny] = '.';
                        q.add(new Node(nx, ny));
                    } else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z' && visited[nx][ny] != key) {
                        if ((key & (1 << (32 + arr[nx][ny]) - 'a')) > 0) {
                            arr[nx][ny] = '.';
                            visited[nx][ny] = key;
                            q.add(new Node(nx, ny));
                        }
                    } else if (arr[nx][ny] == '$') {
                        visited[nx][ny] = key;
                        arr[nx][ny] = '.';
                        cnt++;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }

    private static class Node {
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
    }

}
