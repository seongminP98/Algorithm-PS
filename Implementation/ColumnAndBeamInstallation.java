import java.util.Arrays;

public class ColumnAndBeamInstallation {
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1, 0};
    static int[] dy = {1, -1, 0, 1, -1, 1, -1, 0, 0};

    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        int[][] solution = solution(n, build_frame);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] solution(int n, int[][] build_frame) {
        // build_frame : 가로좌표, 세로좌표, 0기둥 1보, 0삭제 1설치
        int[][] arr = new int[n + 2][n + 2];

        for (int[] build : build_frame) {
            int x = build[0] + 1;
            int y = build[1] + 1;
            if (build[2] == 0) { // 기둥 (1)
                if (build[3] == 1) { // 설치
                    if (canColumn(x, y, arr)) {
                        arr[x][y] |= 1;
                    }
                } else { // 삭제
                    arr[x][y] &= 2;
                    check(x, y, arr, 1);
                }
            } else { // 보 (2)
                if (build[3] == 1) { // 설치
                    if (canRow(x, y, arr)) {
                        arr[x][y] |= 2;
                    }
                } else { // 삭제
                    arr[x][y] &= 1;
                    check(x, y, arr, 2);
                }
            }
            for (int[] ints : arr) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("=============================");
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        int size = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 3) {
                    size += 2;
                } else if (anInt == 1 || anInt == 2) {
                    size += 1;
                }
            }
        }
        int[][] answer = new int[size][3];
        int idx = 0;
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (arr[i][j] == 1) {
                    answer[idx][0] = i - 1;
                    answer[idx][1] = j - 1;
                    answer[idx][2] = 0;
                    idx++;
                } else if (arr[i][j] == 2) {
                    answer[idx][0] = i - 1;
                    answer[idx][1] = j - 1;
                    answer[idx][2] = 1;
                    idx++;
                } else if (arr[i][j] == 3) {
                    answer[idx][0] = i - 1;
                    answer[idx][1] = j - 1;
                    answer[idx][2] = 0;
                    idx++;
                    answer[idx][0] = i - 1;
                    answer[idx][1] = j - 1;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }


        return answer;
    }

    private static void check(int x, int y, int[][] arr, int type) {
        for (int k = 0; k < 9; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (arr[nx][ny] == 1) {
                if (!canColumn(nx, ny, arr)) {
                    arr[x][y] |= type;
                    break;
                }
            } else if (arr[nx][ny] == 2) {
                if (!canRow(nx, ny, arr)) {
                    arr[x][y] |= type;
                    break;
                }
            } else if (arr[nx][ny] == 3) {
                if (!canColumn(nx, ny, arr) || !canRow(nx, ny, arr)) {
                    arr[x][y] |= type;
                    break;
                }
            }
        }
    }

    private static boolean canColumn(int x, int y, int[][] arr) {
        return y == 1 || ((arr[x][y - 1] & 1) > 0) || ((arr[x - 1][y] & 2) > 0) || (arr[x][y] & 2) > 0;
    }

    private static boolean canRow(int x, int y, int[][] arr) {
        return ((arr[x][y - 1] & 1) > 0) || ((arr[x + 1][y - 1] & 1) > 0) || (((arr[x - 1][y] & 2) > 0) && ((arr[x + 1][y]) & 2) > 0);
    }
}
