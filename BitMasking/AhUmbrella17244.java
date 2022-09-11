import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AhUmbrella17244 {
    static int N, M;
    static char[][] arr;
    static int count, allKey;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        count = 0; // 물건의 개수
        char k = 'A';
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'X') { // 물건을 A, B, C, D, E 로 구분.
                    count++;
                    arr[i][j] = k++;
                } else if (arr[i][j] == 'S') {
                    arr[i][j] = '.';
                    q.add(new Node(i, j, 0, 0));
                } else if (arr[i][j] == 'E') { // 도착지를 Z로 변경
                    arr[i][j] = 'Z';
                }
            }
        }
//        for (char[] chars : arr) {
//            System.out.println(Arrays.toString(chars));
//        }
        allKey = (1 << count) - 1; // 모든 물건을 챙겼을 때의 key 값
        bfs();
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[M][N][33];
        visited[q.peek().x][q.peek().y][0] = true;
        while (!q.isEmpty()) {
            Node c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] != '#') {
                    if ((arr[nx][ny] == '.' || arr[nx][ny] == 'Z') && !visited[nx][ny][c.key]) { // 물건없고, 지나갈 수 있음.
                        visited[nx][ny][c.key] = true;
                        q.add(new Node(nx, ny, c.key, c.time + 1));
                    } else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'E') { // 물건
                        int newKey = c.key | (1 << arr[nx][ny] - 'A'); // 물건 줍기
                        if (!visited[nx][ny][newKey]) {
                            visited[nx][ny][newKey] = true;
                            q.add(new Node(nx, ny, newKey, c.time + 1));
                        }
                    }
                    if (arr[nx][ny] == 'Z') {
                        if (c.key == allKey) {
                            System.out.println(c.time + 1);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class Node {
        int x, y, key, time;

        public Node(int x, int y, int key, int time) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", key=" + key +
                    ", time=" + time +
                    '}';
        }
    }
}
