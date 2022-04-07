import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1953 {
    static int N, M, L;
    static Map<Integer, int[][]> deltas = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        deltas.put(1, new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}});// 상 하 좌 우
        deltas.put(2, new int[][]{{-1, 0}, {1, 0}});
        deltas.put(3, new int[][]{{0, -1}, {0, 1}});
        deltas.put(4, new int[][]{{-1, 0}, {0, 1}});
        deltas.put(5, new int[][]{{1, 0}, {0, 1}});
        deltas.put(6, new int[][]{{1, 0}, {0, -1}});
        deltas.put(7, new int[][]{{-1, 0}, {0, -1}});
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Node hall = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
            L = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(bfs(hall, arr)).append('\n');
        }
        System.out.print(sb);
    }

    static int bfs(Node hall, int[][] arr) {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.add(hall);
        visited[hall.x][hall.y] = true;
        int answer = 1;
        while (!q.isEmpty()) {
            Node c = q.poll();
            int[][] delta = deltas.get(arr[c.x][c.y]);
            for (int[] d : delta) {
                int nx = c.x + d[0];
                int ny = c.y + d[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0 && !visited[nx][ny] && check(c.x, c.y, nx, ny, arr) && c.time < L) {
                    q.add(new Node(nx, ny, c.time + 1));
                    visited[nx][ny] = true;
                    answer++;
                }
            }
        }
        return answer;
    }

    static boolean check(int cx, int cy, int nx, int ny, int[][] arr) {
        int nType = arr[nx][ny];
        int[][] nDelta = deltas.get(nType);
        for (int[] nD : nDelta) {
            int nextNx = nx + nD[0];
            int nextNy = ny + nD[1];
            if (nextNx == cx && nextNy == cy) {
                return true;
            }
        }
        return false;
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
