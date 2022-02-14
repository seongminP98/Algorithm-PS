import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire4179 {
    static int R, C;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> fire = new LinkedList<>();
    static Queue<Node> jh = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'F') {
                    fire.offer(new Node(i, j, 0));
                }
                if (arr[i][j] == 'J') {
                    jh.offer(new Node(i, j, 1));
                }
            }
        }
        bfsJ();
        System.out.println("IMPOSSIBLE");
    }

    static void bfsJ() {
        while (!jh.isEmpty()) {
            int size = fire.size();
            while (size-- > 0) {
                int x = fire.peek().x;
                int y = fire.poll().y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && (arr[nx][ny] == '.' || arr[nx][ny] == 'J')) {
                        arr[nx][ny] = 'F';
                        fire.add(new Node(nx, ny, 0));
                    }
                }
            }
            size = jh.size();
            while (size-- > 0) {
                int x = jh.peek().x;
                int y = jh.peek().y;
                int time = jh.poll().time;
                if (escape(x, y)) {
                    System.out.println(time);
                    System.exit(0);
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] == '.') {
                        arr[nx][ny] = 'J';
                        jh.offer(new Node(nx, ny, time + 1));
                    }
                }
            }
        }

    }

    static boolean escape(int x, int y) {
        return x == 0 || y == 0 || x == R - 1 || y == C - 1;
    }

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
