import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze16985 {
    static int[][][] arr;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int answer = 130;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        doublePermutation(0);
        System.out.println(answer == 130 ? -1 : answer);
    }

    private static void permutation(int depth, boolean[] visited, int[] output) {
        if (depth == 5) {
            int[][][] temp = new int[5][5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.arraycopy(arr[output[i]][j], 0, temp[i][j], 0, 5);
                }
            }
            if (temp[0][0][0] != 1 || temp[4][4][4] != 1) {
                return;
            }
            bfs(temp);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (visited[i]) continue;
            output[i] = depth;
            visited[i] = true;
            permutation(depth + 1, visited, output);
            visited[i] = false;
        }
    }

    private static void doublePermutation(int depth) {
        if (depth == 5) {
            permutation(0, new boolean[5], new int[5]);
            return;
        }
        for (int i = 0; i < 4; i++) {
            turnClockwise(depth);
            doublePermutation(depth + 1);
        }
    }


    private static void turnClockwise(int n) {
        int[][] temp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp[i][j] = arr[n][4 - j][i];
            }
        }
        for (int i = 0; i < 5; i++) {
            System.arraycopy(temp[i], 0, arr[n][i], 0, 5);
        }
    }

    private static void bfs(int[][][] temp) {
        boolean[][][] visited = new boolean[5][5][5];
        visited[0][0][0] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.x == 4 && c.y == 4 && c.z == 4) {
                answer = Math.min(answer, c.cnt);
                if (answer == 12) {
                    System.out.println(12);
                    System.exit(0);
                }
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                int nz = c.z + dz[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nz >= 0 && nz < 5 && !visited[nx][ny][nz] && temp[nx][ny][nz] == 1) {
                    q.add(new Node(nx, ny, nz, c.cnt + 1));
                    visited[nx][ny][nz] = true;
                }
            }
        }
    }

    private static class Node {
        int x, y, z, cnt;

        public Node(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}