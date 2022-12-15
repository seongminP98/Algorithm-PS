import java.util.LinkedList;
import java.util.Queue;

public class MovingBlocks {
    static int N;
    // 동 남 서 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        Queue<Robot> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][4];
        visited[0][0][0] = true;
        q.add(new Robot(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Robot c = q.poll();
            if (goal(c)) {
                return c.time;
            }
            for (int i = 0; i < 4; i++) { // 움직임. d 변화 없음
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                int n2x = c.x + dx[c.d] + dx[i];
                int n2y = c.y + dy[c.d] + dy[i];
                if (isIn(nx, ny, n2x, n2y) && board[nx][ny] == 0 && board[n2x][n2y] == 0 && !visited[nx][ny][c.d]) {
                    visited[nx][ny][c.d] = true;
                    q.add(new Robot(nx, ny, c.d, c.time + 1));
                }
            }

            int c2x = c.x + dx[c.d];
            int c2y = c.y + dy[c.d];
            if (c.d == 0 || c.d == 2) {
                for (int i = 1; i <= 3; i += 2) { // d가 1,3으로 바뀜
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    int n2x = c2x + dx[i];
                    int n2y = c2y + dy[i];
                    if (isIn(nx, ny, n2x, n2y) && board[nx][ny] == 0 && board[n2x][n2y] == 0) {
                        if (!visited[c.x][c.y][i]) { // 축이 c
                            visited[c.x][c.y][i] = true;
                            q.add(new Robot(c.x, c.y, i, c.time + 1));
                        }
                        if (!visited[c2x][c2y][i]) { // 축이 c2
                            visited[c2x][c2y][i] = true;
                            q.add(new Robot(c2x, c2y, i, c.time + 1));
                        }
                    }
                }
            } else {
                for (int i = 0; i <= 2; i += 2) { // d가 1,3으로 바뀜
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    int n2x = c2x + dx[i];
                    int n2y = c2y + dy[i];
                    if (isIn(nx, ny, n2x, n2y) && board[nx][ny] == 0 && board[n2x][n2y] == 0) {
                        if (!visited[c.x][c.y][i]) {
                            visited[c.x][c.y][i] = true;
                            q.add(new Robot(c.x, c.y, i, c.time + 1));
                        }
                        if (!visited[c2x][c2y][i]) {
                            visited[c2x][c2y][i] = true;
                            q.add(new Robot(c2x, c2y, i, c.time + 1));
                        }

                    }
                }
            }
        }
        return answer;
    }

    private static boolean goal(Robot robot) {
        if (robot.x == N - 1 && robot.y == N - 1) return true;
        int nx = robot.x + dx[robot.d];
        int ny = robot.y + dy[robot.d];
        if (nx == N - 1 && ny == N - 1) return true;
        return false;
    }

    private static boolean isIn(int x, int y, int x2, int y2) {
        return x >= 0 && x < N && y >= 0 && y < N && x2 >= 0 && x2 < N && y2 >= 0 && y2 < N;
    }

    private static class Robot {
        int x, y, d, time;

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", time=" + time +
                    '}';
        }

        public Robot(int x, int y, int d, int time) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.time = time;
        }
    }
}
