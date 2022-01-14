import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureIsland2589 {
    static int L, W;
    static char[][] map;
    static int answer;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[L][W];
        for (int i = 0; i < L; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        answer = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'W')
                    continue;
                visited = new boolean[L][W];
                answer = Math.max(bfs(i, j), answer);
            }
        }
        System.out.println(answer);

    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;
        int maxHour = 0;
        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int h = q.poll().h;
            maxHour = Math.max(maxHour, h);
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < L && ny >= 0 && ny < W && map[nx][ny] == 'L' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, h + 1));
                }
            }
        }
        return maxHour;
    }

    static class Node {
        int x, y, h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
