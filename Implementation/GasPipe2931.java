import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasPipe2931 {
    static int R, C;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 북동남서
    static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        r = 0;
        c = 0;
        boolean mCheck = false;
        boolean zCheck = false;
        loop:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 0,1,2,3 /북,동,남,서
                switch (arr[i][j]) {
                    case 76: // |
                        if (check(i, j, 0) || check(i, j, 2)) {
                            break loop;
                        }
                        break;
                    case -3: // -
                        if (check(i, j, 1) || check(i, j, 3)) {
                            break loop;
                        }
                        break;
                    case -5: // +
                        if (check(i, j, 0) || check(i, j, 1) || check(i, j, 2) || check(i, j, 3)) {
                            break loop;
                        }
                        break;
                    case 1:
                        if (check(i, j, 1) || check(i, j, 2)) {
                            break loop;
                        }
                        break;
                    case 2:
                        if (check(i, j, 0) || check(i, j, 1)) {
                            break loop;
                        }
                        break;
                    case 3:
                        if (check(i, j, 0) || check(i, j, 3)) {
                            break loop;
                        }
                        break;
                    case 4:
                        if (check(i, j, 2) || check(i, j, 3)) {
                            break loop;
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 29) {//M
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (isIn(nx, ny)) {
                            if (k == 0 && (arr[nx][ny] == 76 || arr[nx][ny] == -5 || arr[nx][ny] == 1 || arr[nx][ny] == 4)) {
                                mCheck = true;
                            } else if (k == 1 && (arr[nx][ny] == -3 && arr[nx][ny] == 3 && arr[nx][ny] == 4 && arr[nx][ny] == -5)) {
                                mCheck = true;
                            } else if (k == 2 && (arr[nx][ny] == 76 && arr[nx][ny] == -5 && arr[nx][ny] == 2 && arr[nx][ny] == 3)) {
                                mCheck = true;
                            } else if (k == 3 && (arr[nx][ny] == -3 && arr[nx][ny] == 1 && arr[nx][ny] == 2 && arr[nx][ny] == -5)) {
                                mCheck = true;
                            }
                        }
                    }
                } else if (arr[i][j] == 42) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (isIn(nx, ny)) {
                            if (k == 0 && (arr[nx][ny] == 76 || arr[nx][ny] == -5 || arr[nx][ny] == 1 || arr[nx][ny] == 4)) {
                                zCheck = true;
                            } else if (k == 1 && (arr[nx][ny] == -3 && arr[nx][ny] == 3 && arr[nx][ny] == 4 && arr[nx][ny] == -5)) {
                                zCheck = true;
                            } else if (k == 2 && (arr[nx][ny] == 76 && arr[nx][ny] == -5 && arr[nx][ny] == 2 && arr[nx][ny] == 3)) {
                                zCheck = true;
                            } else if (k == 3 && (arr[nx][ny] == -3 && arr[nx][ny] == 1 && arr[nx][ny] == 2 && arr[nx][ny] == -5)) {
                                zCheck = true;
                            }
                        }
                    }
                }
            }
        }

        char answer = '0';
        //M:29,Z:42
        boolean[] visited = new boolean[4];
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (isIn(nx, ny)) {

                if ((arr[nx][ny] == 29 && !mCheck)
                        || (arr[nx][ny] == 42 && !zCheck)
                        || arr[nx][ny] == -5) {
                    visited[i] = true;
                } else if (i == 0 && (
                        arr[nx][ny] == 1
                                || arr[nx][ny] == 4 || arr[nx][ny] == 76)) {
                    visited[i] = true;
                } else if (i == 1 && (
                        arr[nx][ny] == 3
                                || arr[nx][ny] == 4 || arr[nx][ny] == -3)) {
                    visited[i] = true;
                } else if (i == 2 && (
                        arr[nx][ny] == 2
                                || arr[nx][ny] == 3 || arr[nx][ny] == 76)) {
                    visited[i] = true;
                } else if (i == 3 && (
                        arr[nx][ny] == 1
                                || arr[nx][ny] == 2 || arr[nx][ny] == -3)) {
                    visited[i] = true;
                }

            }
        }
        if (visited[0] && visited[1] && visited[2] && visited[3]) {
            answer = '+';
        } else if (visited[0] && visited[2]) {
            answer = '|';
        } else if (visited[1] && visited[3]) {
            answer = '-';
        } else if (visited[1] && visited[2]) {
            answer = '1';
        } else if (visited[0] && visited[1]) {
            answer = '2';
        } else if (visited[0] && visited[3]) {
            answer = '3';
        } else if (visited[2] && visited[3]) {
            answer = '4';
        }

        System.out.println((r + 1) + " " + (c + 1) + " " + answer);
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private static boolean check(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (isIn(nx, ny) && arr[nx][ny] == -2) {
            r = nx;
            c = ny;
            return true;
        }
        return false;
    }

}
