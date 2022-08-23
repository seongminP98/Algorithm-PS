import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MovingLogs1938 {
    static int N;
    static Log start, end;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        boolean sFlag = false;
        boolean eFlag = false;

        int fsx = 0;
        int fex = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'B') {
                    if (sFlag) { // 중간 B
                        if (fsx + 1 == i) { // 세로
                            start = new Log(i, j, 2, 0);
                        } else { // 가로
                            start = new Log(i, j, 1, 0);
                        }
                        sFlag = false;
                    } else {
                        sFlag = true;
                        fsx = i;
                    }
                }
                if (arr[i][j] == 'E') {
                    if (eFlag) { // 중간 E
                        if (fex + 1 == i) { // 세로
                            end = new Log(i, j, 2, 0);
                        } else {
                            end = new Log(i, j, 1, 0);
                        }
                        eFlag = false;
                    } else {
                        eFlag = true;
                        fex = i;
                    }
                }
            }
        }
        bfs();
        System.out.println(0);
    }

    private static void bfs() {
        Queue<Log> q = new LinkedList<>();
        q.add(start);
        boolean[][][] visited = new boolean[N][N][3];
        visited[start.x][start.y][start.horizontal] = true;
        while (!q.isEmpty()) {
            Log c = q.poll();
            if (c.equals(end)) {
                System.out.println(c.count);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (canGo(nx, ny, c.horizontal) && !visited[nx][ny][c.horizontal]) {
                    visited[nx][ny][c.horizontal] = true;
                    q.add(new Log(nx, ny, c.horizontal, c.count + 1));
                }
            }
            if (canRotation(c.x, c.y, c.horizontal)) {
                if (!visited[c.x][c.y][c.horizontal % 2 + 1]) {
                    visited[c.x][c.y][c.horizontal % 2 + 1] = true;
                    q.add(new Log(c.x, c.y, c.horizontal % 2 + 1, c.count + 1));
                }
            }
        }
    }

    private static boolean canGo(int x, int y, int dir) {
        if (dir == 1) { // 가로
            if (x >= 0 && x < N && y >= 1 && y < N - 1) {
                if (arr[x][y] != '1' && arr[x][y - 1] != '1' && arr[x][y + 1] != '1') {
                    return true;
                }
            }
        } else { // 세로
            if (x >= 1 && x < N - 1 && y >= 0 && y < N) {
                if (arr[x][y] != '1' && arr[x - 1][y] != '1' && arr[x + 1][y] != '1') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canRotation(int x, int y, int dir) {
        if (dir == 1) { // 가로 > 세로
            if (x == 0 || x == N - 1) {
                return false;
            }
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (arr[i][j] == '1') {
                        return false;
                    }
                }
            }
        } else { // 세로 > 가로
            if (y == 0 || y == N - 1) {
                return false;
            }
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (arr[i][j] == '1') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static class Log {
        int x, y, horizontal; // 통나무 가운데 좌표 / 가로(1)인지 세로(2)인지
        int count;

        public Log(int x, int y, int horizontal, int count) {
            this.x = x;
            this.y = y;
            this.horizontal = horizontal;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Log log = (Log) o;
            return x == log.x && y == log.y && horizontal == log.horizontal;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, horizontal);
        }

        @Override
        public String toString() {
            return "Log{" +
                    "x=" + x +
                    ", y=" + y +
                    ", horizontal=" + horizontal +
                    '}';
        }
    }
}
