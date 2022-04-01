import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MoonRisingGo1194 {
    static int N, M;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][64];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == '0') {
                    q.add(new Node(i, j, 0, 0));
                    arr[i][j] = '.';
                    visited[i][j][0] = true;
                }
            }
        }
//
//        int key = 0;
//        key = (1 << 'a'-'a') | key;
//        key = (1 << 'b'-'a') | key;
//        key = (1 << 'c'-'a') | key;
//        key = (1 << 'd'-'a') | key;
//        key = (1 << 'e'-'a') | key;
//        key = (1 << 'f'-'a') | key;
//
//        System.out.println(key);
//
//        int i1 = key & (1<<'d'-'a'); // >0이면 가지고있음. ==0이면 없음
//        System.out.println(i1);
/** 열쇠먹은 자리를 .으로 바꾸면 통과 못하는 케이스
 * 4 7
 * 1FD...f
 * AC....a
 * #.....#
 * cd....0
 */
        bfs();
        System.out.println(-1);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == '.' && !visited[nx][ny][c.key]) {
                        visited[nx][ny][c.key] = true;
                        q.add(new Node(nx, ny, c.cnt + 1, c.key));
                    } else if (arr[nx][ny] == '1') {
                        System.out.println(c.cnt + 1);
                        System.exit(0);
                    } else if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f' && !visited[nx][ny][c.key]) {
                        int newKey = (1 << arr[nx][ny] - 'a') | c.key;
                        visited[nx][ny][newKey] = true;
                        visited[nx][ny][c.key] = true;
                        q.add(new Node(nx, ny, c.cnt + 1, newKey));
//                        arr[nx][ny] = '.';
                    } else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F' && !visited[nx][ny][c.key]) {
                        int checkKey = c.key & (1 << (32 + arr[nx][ny]) - 'a');
                        if (checkKey > 0) {
                            visited[nx][ny][c.key] = true;
                            q.add(new Node(nx, ny, c.cnt + 1, c.key));
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, cnt, key;


        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", key=" + key +
                    '}';
        }
    }
}
